package org.mickael.consumer.impl.rowmapper;

import org.mickael.consumer.impl.dao.MemberDaoImpl;
import org.mickael.model.bean.Guidebook;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GuidebookRowMapper implements RowMapper<Guidebook> {
    @Override
    public Guidebook mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Guidebook guidebook = new Guidebook();

        guidebook.setId(resultSet.getInt("id"));
        guidebook.setName(resultSet.getString("name"));
        guidebook.setDescription(resultSet.getString("description"));
        guidebook.setAddedDate(resultSet.getTimestamp("added_date"));
        guidebook.setLoaned(resultSet.getBoolean("is_loaned"));

        MemberDaoImpl memberDao = new MemberDaoImpl();
        guidebook.setMember(memberDao.findMember(resultSet.getInt("member_id")));


        return guidebook;
    }
}
