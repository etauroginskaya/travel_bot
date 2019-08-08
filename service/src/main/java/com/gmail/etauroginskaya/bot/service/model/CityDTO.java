package com.gmail.etauroginskaya.bot.service.model;

import com.gmail.etauroginskaya.bot.service.validator.annotations.CityIDExists;
import com.gmail.etauroginskaya.bot.service.validator.annotations.UniqueCityName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

public class CityDTO {
    public interface New {
    }

    public interface Update {
    }

    @NotNull(groups = {Update.class})
    @CityIDExists(groups = {Update.class})
    @Null(groups = {New.class})
    private String id;
    @NotBlank(groups = {New.class, Update.class})
    @Size(max = 60, groups = {New.class, Update.class})
    @UniqueCityName(groups = {New.class, Update.class})
    private String name;
    @NotBlank(groups = {New.class, Update.class})
    @Size(max = 1000, groups = {New.class, Update.class})
    private String description;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}