package com.gmail.etauroginskaya.springboot.controller;

import com.gmail.etauroginskaya.bot.service.CityService;
import com.gmail.etauroginskaya.bot.service.model.CityDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class CityAPIController {
    private final CityService cityService;

    public CityAPIController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/cities")
    public ResponseEntity saveCity(@Validated(CityDTO.New.class) @RequestBody CityDTO cityDTO,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors()
                    .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return new ResponseEntity(errors.toString(), HttpStatus.BAD_REQUEST);
        }
        cityService.addCity(cityDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/cities/{id}")
    public ResponseEntity deleteCityById(@PathVariable("id") Long id) {
        if (cityService.deleteCityById(id) == null) {
            return new ResponseEntity("Not found city with id=".concat(id.toString()), HttpStatus.NOT_FOUND);
        } else
            return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/cities")
    public ResponseEntity updateCity(@Validated(CityDTO.Update.class) @RequestBody CityDTO cityDTO,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors()
                    .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return new ResponseEntity(errors.toString(), HttpStatus.BAD_REQUEST);
        }
        cityService.update(cityDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}