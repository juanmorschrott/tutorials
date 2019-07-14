package com.juanmorschrott.hotel.controller;

import com.juanmorschrott.hotel.model.Hotel;
import com.juanmorschrott.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/v1/hotels")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping()
    public ResponseEntity findAll() {

        List<Hotel> hotels = (List<Hotel>) hotelRepository.findAll();

        if (!hotels.isEmpty()) {
            return new ResponseEntity<>(hotels, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity findByCity(@RequestParam("city") String city,
                                     @RequestParam("start") Integer start,
                                     @RequestParam("limit") Integer limit) {

        if (city == null || start == null || limit == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Pageable firstPage = PageRequest.of(start, limit);

        Page<Hotel> hotels = hotelRepository.findByCity(city, firstPage);

        if (!hotels.isEmpty()) {
            return new ResponseEntity<>(hotels.getContent(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
