package com.romandemkiv.spring.springboot.spring_cource_springboot.controller;


import com.romandemkiv.spring.springboot.spring_cource_springboot.config.CurrencyServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {
    @Autowired
    private CurrencyServiceConfiguration configuration;

    @GetMapping("/currency-configuration")
    public CurrencyServiceConfiguration getConfiguration() {
        return configuration;
    }
}
