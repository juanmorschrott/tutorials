package com.juanmorschrott.geoEspatial.service;

import com.juanmorschrott.geoEspatial.model.City;
import com.juanmorschrott.geoEspatial.model.Point;

import java.sql.SQLException;

public interface GeoService {

    void insertCity(City city) throws SQLException;

    void deleteAll() throws SQLException;

    City searchClosestCity(Point point);

}
