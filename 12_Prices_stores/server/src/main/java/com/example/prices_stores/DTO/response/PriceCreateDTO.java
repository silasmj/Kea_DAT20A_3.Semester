package com.example.prices_stores.DTO.response;

import com.example.prices_stores.models.Price;

public class PriceCreateDTO {

    public Price price;
    public boolean failed;
    public String errorMessage;

    public PriceCreateDTO(Price price) {
        this.price = price;
    }

    public PriceCreateDTO(String errorMessage) {
        this.errorMessage = errorMessage;
        this.failed = true;
    }

}
