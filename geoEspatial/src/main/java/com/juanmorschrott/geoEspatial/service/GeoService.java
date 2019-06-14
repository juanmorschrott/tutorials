package com.juanmorschrott.geoEspatial.service;

import com.juanmorschrott.geoEspatial.model.City;

import java.sql.SQLException;

public interface GeoService {

    void insertCity(City city) throws SQLException;

    void deleteAll() throws SQLException;

}
