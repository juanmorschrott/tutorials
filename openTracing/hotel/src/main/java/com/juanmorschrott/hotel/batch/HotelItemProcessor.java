package com.juanmorschrott.hotel.batch;

import com.juanmorschrott.hotel.model.Hotel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class HotelItemProcessor implements ItemProcessor<Hotel, Hotel> {

    private static final Logger log = LoggerFactory.getLogger(HotelItemProcessor.class);

    @Override
    public Hotel process(final Hotel hotel) throws Exception {
        final String id = hotel.getId();
        final String address = hotel.getAddress().toUpperCase();
        final String city = hotel.getCity().toUpperCase();
        final String country = hotel.getCountry().toUpperCase();
        final String name = hotel.getName().toUpperCase();

        final Hotel transformedHotel = new Hotel(id, address, city, country, name);

        log.info("Converting (" + hotel + ") into (" + transformedHotel + ")");

        return transformedHotel;
    }

}
