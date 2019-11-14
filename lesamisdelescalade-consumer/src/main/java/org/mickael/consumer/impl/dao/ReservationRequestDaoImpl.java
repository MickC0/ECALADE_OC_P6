package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.ReservationRequestDao;
import org.mickael.consumer.impl.AbstractDataSource;
import org.mickael.consumer.impl.rowmapper.ReservationRequestRowMapper;
import org.mickael.model.bean.ReservationRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Types;
import java.util.List;

public class ReservationRequestDaoImpl extends AbstractDataSource implements ReservationRequestDao {

    @Override
    public void createReservationRequest(ReservationRequest reservationRequest) {
        String sql = "INSERT INTO public.reservation_request (id, member_id, guidebook_id, reservation_state)"
                             + "VALUES (:id, :memberId, :guidebookId, :reservationState)";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", reservationRequest.getId(), Types.INTEGER);
        parameterSource.addValue("memberId", reservationRequest.getMember().getId(), Types.INTEGER);
        parameterSource.addValue("guidebookId", reservationRequest.getGuidebook().getId(), Types.INTEGER);
        parameterSource.addValue("reservationState", reservationRequest.getReservationState().getStateValue(), Types.VARCHAR);


        namedParameterJdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public ReservationRequest findReservationRequestByGuidebookId (Integer id) {
        String sql = "SELECT * FROM public.reservation_request WHERE guidebook_id = :guidebook_id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("guidebook_id", id, Types.INTEGER);
        ReservationRequestRowMapper reservationRequestRowMapper = new ReservationRequestRowMapper();
        ReservationRequest reservationRequest = namedParameterJdbcTemplate.queryForObject(sql, parameterSource, reservationRequestRowMapper);

        return reservationRequest;
    }

    @Override
    public ReservationRequest findReservationRequestByMemberId (Integer id) {
        String sql = "SELECT * FROM public.reservation_request WHERE member_id = :member_id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("member_id", id, Types.INTEGER);
        ReservationRequestRowMapper reservationRequestRowMapper = new ReservationRequestRowMapper();
        ReservationRequest reservationRequest = namedParameterJdbcTemplate.queryForObject(sql, parameterSource, reservationRequestRowMapper);

        return reservationRequest;
    }

    @Override
    public void updateReservationRequest(ReservationRequest reservationRequest) {
        String sql = "UPDATE public.reservation_request SET "
                             + "member_id = :memberId, "
                             + "guidebook_id = :guidebookId "
                             + "WHERE id = :id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("memberId", reservationRequest.getMember().getId(), Types.INTEGER);
        parameterSource.addValue("guidebookId", reservationRequest.getGuidebook().getId(), Types.INTEGER);


        namedParameterJdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public void deleteReservationRequest(Integer id) {
        String sql = "DELETE FROM public.reservation_request WHERE guidebook_id = :id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("id", id);
        namedParameterJdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public List<ReservationRequest> findAllReservationRequest() {
        String sql = "SELECT * FROM public.reservation_request";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        ReservationRequestRowMapper reservationRequestRowMapper = new ReservationRequestRowMapper();
        List<ReservationRequest> reservationRequestList = jdbcTemplate.query(sql, reservationRequestRowMapper);

        return reservationRequestList;
    }

    @Override
    public List<ReservationRequest> findAllReservationRequestByMemberId(Integer id) {
        String sql = "SELECT * FROM public.reservation_request WHERE member_id = "+id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        ReservationRequestRowMapper reservationRequestRowMapper = new ReservationRequestRowMapper();
        List<ReservationRequest> reservationRequestList = jdbcTemplate.query(sql, reservationRequestRowMapper);

        return reservationRequestList;
    }

    @Override
    public List<ReservationRequest> findAllReservationRequestByGuidebookId(Integer id) {
        String sql = "SELECT * FROM public.reservation_request WHERE guidebook_id = "+id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        ReservationRequestRowMapper reservationRequestRowMapper = new ReservationRequestRowMapper();
        List<ReservationRequest> reservationRequestList = jdbcTemplate.query(sql, reservationRequestRowMapper);

        return reservationRequestList;
    }
}
