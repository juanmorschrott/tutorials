package com.juanmorschrott.hotel.repository;

import com.juanmorschrott.hotel.model.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Hotel, Long> {
}
