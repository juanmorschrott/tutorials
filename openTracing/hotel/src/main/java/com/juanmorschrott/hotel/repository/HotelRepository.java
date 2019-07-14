package com.juanmorschrott.hotel.repository;

import com.juanmorschrott.hotel.model.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface HotelRepository extends CrudRepository<Hotel, String> {

    Page<Hotel> findByCity(String city, Pageable pageable);

}
