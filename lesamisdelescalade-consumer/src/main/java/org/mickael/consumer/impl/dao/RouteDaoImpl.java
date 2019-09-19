package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.RouteDao;
import org.mickael.consumer.impl.AbstractDataSourceImpl;
import org.mickael.consumer.impl.rowmapper.RouteRowMapper;
import org.mickael.model.bean.Route;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Types;
import java.util.List;

public class RouteDaoImpl  extends AbstractDataSourceImpl implements RouteDao {

    @Override
    public void createRoute(Route route) {
        String sql = "INSERT INTO public.route (sector_id, name, description, cotation, height, pitch_number)"
                             + "VALUES (:sectorId, :name, :description, :cotation, :height, :pitchNumber)";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("sectorId", route.getSector().getId(), Types.INTEGER);
        parameterSource.addValue("name", route.getName(), Types.VARCHAR);
        parameterSource.addValue("description", route.getDescription(), Types.VARCHAR);
        parameterSource.addValue("cotation", route.getCotation(), Types.VARCHAR);
        parameterSource.addValue("height", route.getHeight(), Types.FLOAT);
        parameterSource.addValue("pitchNumber", route.getPitchNumber(), Types.INTEGER);

        jdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public Route findRoute(Integer id) {
        String sql = "SELECT * FROM public.route"
                             + " WHERE id = " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        RouteRowMapper routeRowMapper = new RouteRowMapper();
        Route route = jdbcTemplate.queryForObject(sql, routeRowMapper);

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

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("sectorId", route.getSector().getId(), Types.INTEGER);
        parameterSource.addValue("name", route.getName(), Types.VARCHAR);
        parameterSource.addValue("description", route.getDescription(), Types.VARCHAR);
        parameterSource.addValue("cotation", route.getCotation(), Types.VARCHAR);
        parameterSource.addValue("height", route.getHeight(), Types.FLOAT);
        parameterSource.addValue("pitchNumber", route.getPitchNumber(), Types.INTEGER);

        jdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public void deleteRoute(Integer id) {
        String sql = "DELETE FROM public.route WHERE id = :id";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("id", id);
        jdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public List<Route> findAllRoute() {
        String sql = "SELECT * FROM public.route";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        RouteRowMapper routeRowMapper = new RouteRowMapper();
        List<Route> routeList = jdbcTemplate.query(sql, routeRowMapper);

        return routeList;
    }
}
