package org.mickael.consumer.impl.rowmapper;

import org.mickael.consumer.impl.dao.ClimbingAreaDaoImpl;
import org.mickael.model.bean.StartingPoint;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StartingPointRowMapper implements RowMapper<StartingPoint> {
    @Override
    public StartingPoint mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        StartingPoint StartingPoint = new StartingPoint();

        StartingPoint.setId(resultSet.getInt("id"));
        StartingPoint.setName(resultSet.getString("name"));
        StartingPoint.setLatitude(resultSet.getString("latitude"));
        StartingPoint.setLongitude(resultSet.getString("longitude"));

        ClimbingAreaDaoImpl climbingAreaDao = new ClimbingAreaDaoImpl();
        StartingPoint.setClimbingArea(climbingAreaDao.findClimbingArea(resultSet.getInt("climbingArea_id")));


        return StartingPoint;
    }
}
