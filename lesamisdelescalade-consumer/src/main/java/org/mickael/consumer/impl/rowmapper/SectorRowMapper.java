package org.mickael.consumer.impl.rowmapper;

import org.mickael.consumer.impl.dao.ClimbingAreaDaoImpl;
import org.mickael.model.bean.Sector;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SectorRowMapper implements RowMapper<Sector> {
    @Override
    public Sector mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Sector sector = new Sector();

        sector.setId(resultSet.getInt("id"));
        sector.setName(resultSet.getString("name"));
        sector.setDescription(resultSet.getString("description"));

        ClimbingAreaDaoImpl climbingAreaDao = new ClimbingAreaDaoImpl();
        sector.setClimbingArea(climbingAreaDao.findClimbingArea(resultSet.getInt("climbingArea_id")));

        return sector;
    }
}
