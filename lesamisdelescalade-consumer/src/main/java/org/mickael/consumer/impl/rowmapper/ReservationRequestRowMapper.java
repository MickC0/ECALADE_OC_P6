package org.mickael.consumer.impl.rowmapper;

import org.mickael.consumer.impl.dao.GuidebookDaoImpl;
import org.mickael.consumer.impl.dao.MemberDaoImpl;
import org.mickael.model.bean.ReservationRequest;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationRequestRowMapper implements RowMapper<ReservationRequest> {
    @Override
    public ReservationRequest mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        ReservationRequest reservationRequest = new ReservationRequest();
        reservationRequest.setId(resultSet.getInt("id"));

        MemberDaoImpl memberDao = new MemberDaoImpl();
        reservationRequest.setMember(memberDao.findMember(resultSet.getInt("member_id")));

        GuidebookDaoImpl guidebookDao = new GuidebookDaoImpl();
        reservationRequest.setGuidebook(guidebookDao.findGuidebook(resultSet.getInt("guidebook_id")));

        reservationRequest.setStatus(resultSet.getString("status"));

        return reservationRequest;
    }
}
