package com.juanmorschrott.hotel.controller;

import com.juanmorschrott.hotel.model.Hotel;
import com.juanmorschrott.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/hotels")
    public ResponseEntity findAll() {

        List<Hotel> hotels = (List<Hotel>) hotelRepository.findAll();
        ResponseEntity response;

        if (!hotels.isEmpty()) {
            response = new ResponseEntity<>(hotels, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return response;
    }

}
