package org.mickael.consumer.impl.rowmapper;

import org.mickael.consumer.impl.dao.SectorDaoImpl;
import org.mickael.model.bean.Route;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RouteRowMapper implements RowMapper<Route> {
    @Override
    public Route mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Route route = new Route();

        route.setId(resultSet.getInt("id"));
        route.setName(resultSet.getString("name"));
        route.setDescription(resultSet.getString("description"));
        route.setCotation(resultSet.getString("cotation"));
        route.setHeight(resultSet.getFloat("height"));

        SectorDaoImpl sectorDao = new SectorDaoImpl();
        route.setSector(sectorDao.findSector(resultSet.getInt("sector_id")));



        return route;
    }
}
