package org.example.model;

import jakarta.validation.constraints.NotBlank;

public class Payload {

    @NotBlank
    private String price;

    public String getPrice() {
        return price;
    }
}
