package com.juanmorschrott.geoEspatial;

import com.juanmorschrott.geoEspatial.model.City;
import com.juanmorschrott.geoEspatial.service.GeoServiceImpl;
import org.postgis.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeoEspatialApplication implements ApplicationRunner {

	private GeoServiceImpl geoService;

	@Autowired
	public GeoEspatialApplication(GeoServiceImpl geoService) {
		this.geoService = geoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(GeoEspatialApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		geoService.deleteAll();

		City c1 = new City();
		c1.setName("Madrid");
		c1.setLocation(new Point(40.416775, -3.703790));
		geoService.insertCity(c1);

		City c2 = new City();
		c2.setName("Londres");
		c2.setLocation(new Point(51.507351, -0.127758));
		geoService.insertCity(c2);

		City c3 = new City();
		c3.setName("Budapest");
		c3.setLocation(new Point(47.497913, 19.040236));
		geoService.insertCity(c3);
	}
}
