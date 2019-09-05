package org.mickael.consumer.impl.rowmapper;

import org.mickael.consumer.impl.dao.ClimbingAreaDaoImpl;
import org.mickael.model.bean.Parking;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParkingRowMapper implements RowMapper<Parking> {
    @Override
    public Parking mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Parking parking = new Parking();

        parking.setId(resultSet.getInt("id"));
        parking.setName(resultSet.getString("name"));
        parking.setLatitude(resultSet.getString("latitude"));
        parking.setLongitude(resultSet.getString("longitude"));

        ClimbingAreaDaoImpl climbingAreaDao = new ClimbingAreaDaoImpl();
        parking.setClimbingArea(climbingAreaDao.findClimbingArea(resultSet.getInt("climbingArea_id")));


        return parking;
    }
}
