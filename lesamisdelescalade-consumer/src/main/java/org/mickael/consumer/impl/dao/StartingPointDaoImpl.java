package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.StartingPointDao;
import org.mickael.consumer.impl.AbstractDao;
import org.mickael.consumer.impl.rowmapper.StartingPointRowMapper;
import org.mickael.model.bean.StartingPoint;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.sql.Types;
import java.util.List;

public class StartingPointDaoImpl extends AbstractDao implements StartingPointDao {

    @Override
    public void createStartingPoint(StartingPoint startingPoint) {
        String sql = "INSERT INTO public.startingPoint (climbingarea_id, name, latitude, longitude)"
                             + "VALUES (:climbingareaId, :name, :latitude, :longitude)";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("climbingareaId", startingPoint.getClimbingArea().getId(), Types.INTEGER);
        parameterSource.addValue("name", startingPoint.getName(), Types.VARCHAR);
        parameterSource.addValue("latitude", startingPoint.getLatitude(), Types.VARCHAR);
        parameterSource.addValue("longitude", startingPoint.getLongitude(), Types.VARCHAR);


        getJdbcTemplate().update(sql, parameterSource);

    }

    @Override
    public StartingPoint findStartingPoint(Integer id) {
        String sql = "SELECT * FROM public.startingPoint WHERE id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id, Types.INTEGER);
        StartingPointRowMapper startingPointRowMapper = new StartingPointRowMapper();
        StartingPoint startingPoint = getNamedParameterJdbcTemplate().queryForObject(sql, parameterSource, startingPointRowMapper);

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

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("climbingareaId", startingPoint.getClimbingArea().getId(), Types.INTEGER);
        parameterSource.addValue("name", startingPoint.getName(), Types.VARCHAR);
        parameterSource.addValue("latitude", startingPoint.getLatitude(), Types.VARCHAR);
        parameterSource.addValue("longitude", startingPoint.getLongitude(), Types.VARCHAR);


        getNamedParameterJdbcTemplate().update(sql, parameterSource);

    }

    @Override
    public void deleteStartingPoint(Integer id) {
        String sql = "DELETE FROM public.startingPoint WHERE id = :id";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("id", id);
        getNamedParameterJdbcTemplate().update(sql, parameterSource);

    }

    @Override
    public List<StartingPoint> findAllStartingPoint() {
        String sql = "SELECT * FROM public.startingPoint";
        StartingPointRowMapper startingPointRowMapper = new StartingPointRowMapper();
        List<StartingPoint> startingPointList = getJdbcTemplate().query(sql, startingPointRowMapper);

        return startingPointList;
    }
}
