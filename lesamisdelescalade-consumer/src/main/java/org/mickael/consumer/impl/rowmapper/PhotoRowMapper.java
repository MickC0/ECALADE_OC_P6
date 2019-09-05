package org.mickael.consumer.impl.rowmapper;

import org.mickael.consumer.impl.dao.ClimbingAreaDaoImpl;
import org.mickael.model.bean.Photo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhotoRowMapper implements RowMapper<Photo> {
    @Override
    public Photo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Photo photo = new Photo();

        photo.setId(resultSet.getInt("id"));
        photo.setName(resultSet.getString("name"));
        photo.setUrl(resultSet.getString("url"));

        ClimbingAreaDaoImpl climbingAreaDao = new ClimbingAreaDaoImpl();
        photo.setClimbingArea(climbingAreaDao.findClimbingArea(resultSet.getInt("climbingArea_id")));

        return photo;
    }
}
