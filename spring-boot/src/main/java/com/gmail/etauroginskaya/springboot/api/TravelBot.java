package com.gmail.etauroginskaya.springboot.api;

import com.gmail.etauroginskaya.bot.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TravelBot extends TelegramLongPollingBot {
    private static final Logger logger = LoggerFactory.getLogger(TravelBot.class);
    private static final String BOT_USERNAME = "@AlenasTravelBot";
    private static final String BOT_TOKEN = "931236200:AAH_RrWX2-ouAUxwyuFQyTLOUMXQ2XSp81A";
    private final CityService cityService;

    public TravelBot(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "/help":
                case ("/help" + BOT_USERNAME):
                    sendMessage(message, "I can give background information about the entered city.");
                    break;
                default:
                    sendMessage(message, cityService.getDescriptionByName(message.getText()));
            }
        }
    }

    private void sendMessage(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            logger.error(e.getMessage(), e);
        }

    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}