package com.juanmorschrott.hotel.controller;

import com.juanmorschrott.hotel.model.Hotel;
import com.juanmorschrott.hotel.repository.HotelRepository;
import io.opentracing.Span;
import io.opentracing.Tracer;
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

    private static final String HOTEL_SERVICE = "hotel_service";

    @Autowired
    private HotelRepository hotelRepository;

    // @Autowired
    // private Tracer tracer;

    @GetMapping("/hotels")
    public ResponseEntity findAll() {

        // Span span = tracer.buildSpan(HOTEL_SERVICE).start();

        List<Hotel> hotels = (List<Hotel>) hotelRepository.findAll();
        ResponseEntity response;

        if (!hotels.isEmpty()) {
            // span.setTag("http.status_code", 200);
            response = new ResponseEntity<>(hotels, HttpStatus.OK);
        } else {
            // span.setTag("http.status_code", 404);
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // span.finish();

        return response;
    }

}
