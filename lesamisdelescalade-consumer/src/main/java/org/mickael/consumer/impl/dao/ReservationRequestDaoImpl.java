package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.ReservationRequestDao;
import org.mickael.consumer.impl.AbstractDataSourceImpl;
import org.mickael.consumer.impl.rowmapper.ReservationRequestRowMapper;
import org.mickael.model.bean.ReservationRequest;
import org.mickael.model.bean.ReservationRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Types;
import java.util.List;

public class ReservationRequestDaoImpl extends AbstractDataSourceImpl implements ReservationRequestDao {

    @Override
    public void createReservationRequest(ReservationRequest reservationRequest) {
        String sql = "INSERT INTO public.reservation_request (id, member_id, guidebook_id, transaction_status)"
                             + "VALUES (:id, :memberId, :guidebookId, :transactionStatus)";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("memberId", reservationRequest.getMember().getId(), Types.INTEGER);
        parameterSource.addValue("guidebookId", reservationRequest.getGuidebook().getId(), Types.INTEGER);


        jdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public ReservationRequest findReservationRequestByGuidebookId (Integer id) {
        String sql = "SELECT * FROM public.reservation_request"
                             + " WHERE guidebook_id = " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        ReservationRequestRowMapper reservationRequestRowMapper = new ReservationRequestRowMapper();
        ReservationRequest reservationRequest = jdbcTemplate.queryForObject(sql, reservationRequestRowMapper);

        return reservationRequest;
    }

    @Override
    public ReservationRequest findReservationRequestByMemberId (Integer id) {
        String sql = "SELECT * FROM public.reservation_request"
                             + " WHERE member_id = " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        ReservationRequestRowMapper reservationRequestRowMapper = new ReservationRequestRowMapper();
        ReservationRequest reservationRequest = jdbcTemplate.queryForObject(sql, reservationRequestRowMapper);

        return reservationRequest;
    }

    @Override
    public void updateReservationRequest(ReservationRequest reservationRequest) {
        String sql = "UPDATE public.reservation_request SET "
                             + "member_id = :memberId, "
                             + "guidebook_id = :guidebookId "
                             + "WHERE id = :id";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("memberId", reservationRequest.getMember().getId(), Types.INTEGER);
        parameterSource.addValue("guidebookId", reservationRequest.getGuidebook().getId(), Types.INTEGER);


        jdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public void deleteReservationRequest(Integer id) {
        String sql = "DELETE FROM public.reservation_request WHERE guidebook_id = :id";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("id", id);
        jdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public List<ReservationRequest> findAllReservationRequest() {
        String sql = "SELECT * FROM public.reservation_request";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        ReservationRequestRowMapper reservationRequestRowMapper = new ReservationRequestRowMapper();
        List<ReservationRequest> reservationRequestList = jdbcTemplate.query(sql, reservationRequestRowMapper);

        return reservationRequestList;
    }
}
