package com.juanmorschrott.geoEspatial.model;

import lombok.Data;
import org.postgis.Geometry;

@Data
public class City {

    private Long id;

    private String name;

    private Geometry location;

}
