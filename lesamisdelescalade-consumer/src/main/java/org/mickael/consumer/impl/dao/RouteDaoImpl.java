package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.RouteDao;
import org.mickael.consumer.impl.AbstractDao;
import org.mickael.consumer.impl.rowmapper.RouteRowMapper;
import org.mickael.model.bean.Route;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.sql.Types;
import java.util.List;

public class RouteDaoImpl  extends AbstractDao implements RouteDao {

    @Override
    public void createRoute(Route route) {
        String sql = "INSERT INTO public.route (sector_id, name, description, cotation, height, pitch_number)"
                             + "VALUES (:sectorId, :name, :description, :cotation, :height, :pitchNumber)";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("sectorId", route.getSector().getId(), Types.INTEGER);
        parameterSource.addValue("name", route.getName(), Types.VARCHAR);
        parameterSource.addValue("description", route.getDescription(), Types.VARCHAR);
        parameterSource.addValue("cotation", route.getCotation(), Types.VARCHAR);
        parameterSource.addValue("height", route.getHeight(), Types.FLOAT);
        parameterSource.addValue("pitchNumber", route.getPitchNumber(), Types.INTEGER);

        getNamedParameterJdbcTemplate().update(sql, parameterSource);

    }

    @Override
    public Route findRoute(Integer id) {
        String sql = "SELECT * FROM public.route WHERE id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id, Types.INTEGER);
        RouteRowMapper routeRowMapper = new RouteRowMapper();
        Route route = getNamedParameterJdbcTemplate().queryForObject(sql, parameterSource, routeRowMapper);

        return route;
    }

    @Override
    public void updateRoute(Route route) {
        String sql = "UPDATE public.route SET "
                             + "sector_id = :sectorId, "
                             + "name = :name, "
                             + "description = :description, "
                             + "cotation = :cotation, "
                             + "height = :height, "
                             + "pitch_number = :pitchNumber "
                             + "WHERE id = :id";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("sectorId", route.getSector().getId(), Types.INTEGER);
        parameterSource.addValue("name", route.getName(), Types.VARCHAR);
        parameterSource.addValue("description", route.getDescription(), Types.VARCHAR);
        parameterSource.addValue("cotation", route.getCotation(), Types.VARCHAR);
        parameterSource.addValue("height", route.getHeight(), Types.FLOAT);
        parameterSource.addValue("pitchNumber", route.getPitchNumber(), Types.INTEGER);

        getNamedParameterJdbcTemplate().update(sql, parameterSource);

    }

    @Override
    public void deleteRoute(Integer id) {
        String sql = "DELETE FROM public.route WHERE id = :id";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("id", id);
        getNamedParameterJdbcTemplate().update(sql, parameterSource);

    }

    @Override
    public List<Route> findAllRoute() {
        String sql = "SELECT * FROM public.route";
        RouteRowMapper routeRowMapper = new RouteRowMapper();
        List<Route> routeList = getJdbcTemplate().query(sql, routeRowMapper);

        return routeList;
    }
}
