package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.StartingPointDao;
import org.mickael.consumer.impl.AbstractDataSourceImpl;
import org.mickael.consumer.impl.rowmapper.StartingPointRowMapper;
import org.mickael.model.bean.StartingPoint;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Types;
import java.util.List;

public class StartingPointDaoImpl extends AbstractDataSourceImpl implements StartingPointDao {

    @Override
    public void createStartingPoint(StartingPoint startingPoint) {
        String sql = "INSERT INTO public.startingPoint (climbingarea_id, name, latitude, longitude)"
                             + "VALUES (:climbingareaId, :name, :latitude, :longitude)";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("climbingareaId", startingPoint.getClimbingArea().getId(), Types.INTEGER);
        parameterSource.addValue("name", startingPoint.getName(), Types.VARCHAR);
        parameterSource.addValue("latitude", startingPoint.getLatitude(), Types.VARCHAR);
        parameterSource.addValue("longitude", startingPoint.getLongitude(), Types.VARCHAR);


        jdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public StartingPoint findStartingPoint(Integer id) {
        String sql = "SELECT * FROM public.startingPoint"
                             + " WHERE id = " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        StartingPointRowMapper startingPointRowMapper = new StartingPointRowMapper();
        StartingPoint startingPoint = jdbcTemplate.queryForObject(sql, startingPointRowMapper);

        return startingPoint;
    }

    @Override
    public void updateStartingPoint(StartingPoint startingPoint) {
        String sql = "UPDATE public.startingPoint SET "
                             + "climbingarea_id = :climbingAreaId, "
                             + "name = :name, "
                             + "latitude = :latitude, "
                             + "longitude = :longitude "
                             + "WHERE id = :id";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("climbingareaId", startingPoint.getClimbingArea().getId(), Types.INTEGER);
        parameterSource.addValue("name", startingPoint.getName(), Types.VARCHAR);
        parameterSource.addValue("latitude", startingPoint.getLatitude(), Types.VARCHAR);
        parameterSource.addValue("longitude", startingPoint.getLongitude(), Types.VARCHAR);


        jdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public void deleteStartingPoint(Integer id) {
        String sql = "DELETE FROM public.startingPoint WHERE id = :id";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("id", id);
        jdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public List<StartingPoint> findAllStartingPoint() {
        String sql = "SELECT * FROM public.startingPoint";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        StartingPointRowMapper startingPointRowMapper = new StartingPointRowMapper();
        List<StartingPoint> startingPointList = jdbcTemplate.query(sql, startingPointRowMapper);

        return startingPointList;
    }
}
