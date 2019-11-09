package org.mickael.consumer.impl.rowmapper;

import org.mickael.consumer.impl.dao.MemberDaoImpl;
import org.mickael.model.bean.ClimbingArea;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClimbingAreaRowMapper implements RowMapper<ClimbingArea> {

    @Override
    public ClimbingArea mapRow(ResultSet resultSet, int rowNum) throws SQLException{


        ClimbingArea climbingArea = new ClimbingArea();

        climbingArea.setId(resultSet.getInt("id"));
        climbingArea.setName(resultSet.getString("name"));
        climbingArea.setRegion(resultSet.getString("region"));
        climbingArea.setDescription(resultSet.getString("description"));
        climbingArea.setProfil(resultSet.getString("profil"));
        climbingArea.setRockType(resultSet.getString("rock_type"));
        climbingArea.setMaximumHeight(resultSet.getFloat("maximum_height"));
        climbingArea.setApprouved(resultSet.getBoolean("is_approuved"));

        //on appelle la dao de l'objet souhaité pour créer le bean member
        MemberDaoImpl memberDao = new MemberDaoImpl();
        climbingArea.setMember(memberDao.findMember(resultSet.getInt("member_id")));


        return climbingArea;
    }
}
