package com.juanmorschrott.geoEspatial.service;

import com.juanmorschrott.geoEspatial.model.City;
import com.juanmorschrott.geoEspatial.model.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class GeoServiceImpl implements GeoService {

    Logger logger = LoggerFactory.getLogger(GeoServiceImpl.class);

    private Connection conn;
    private Statement s;
    private ResultSet r;

    @Override
    public void insertCity(City city) throws SQLException {
        try {
            connect();

            StringBuilder query = new StringBuilder();
            query.append("INSERT INTO CITY (name, location) VALUES ('");
            query.append(city.getName());
            query.append("', ST_GeographyFromText('SRID=4326;");
            query.append(city.getLocation());
            query.append("'));");

            s = conn.createStatement();
            s.execute(query.toString());
        } catch (Exception e) {
            logger.error("Error while trying to insert a city");
        } finally {
            s.close();
            conn.close();
        }
    }

    @Override
    public void deleteAll() throws SQLException {
        try {
            connect();
            String query = "DELETE FROM CITY;";

            s = conn.createStatement();
            s.execute(query);
        } catch (Exception e) {
            logger.error("Error while trying to insert a city");
        } finally {
            s.close();
            conn.close();
        }
    }

    @Override
    public City searchClosestCity(Point point) {

        return new City();
    }

    private void connect() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://172.17.0.2:5432/postgres";
            conn = DriverManager.getConnection(url, "postgres", "postgres");
            ((org.postgresql.PGConnection) conn).addDataType("geometry", Class.forName("org.postgis.PGgeometry"));
        } catch (Exception e) {
            conn.close();
        }
    }
}
