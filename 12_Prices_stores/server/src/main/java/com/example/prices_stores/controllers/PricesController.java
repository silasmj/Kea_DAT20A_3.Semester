package com.example.prices_stores.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PricesController {

    @GetMapping("/prices")
    public String getPrices() {
        return "Get the prices here";
    }
}
