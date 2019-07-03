package com.juanmorschrott.frontend.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Hotel {
    private String id;
    private String address;
    private String city;
    private String country;
    private String name;

    public Hotel() {}

    public Hotel(String id, String address, String city, String country, String name) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.country = country;
        this.name = name;
    }
}
