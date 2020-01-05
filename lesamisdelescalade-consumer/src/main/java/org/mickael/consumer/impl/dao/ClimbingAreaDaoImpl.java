package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.ClimbingAreaDao;
import org.mickael.consumer.impl.AbstractDataSource;
import org.mickael.consumer.impl.rowmapper.ClimbingAreaRowMapper;
import org.mickael.model.bean.ClimbingArea;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Types;
import java.util.List;

public class ClimbingAreaDaoImpl extends AbstractDataSource implements ClimbingAreaDao {


    /**
     * Create a new climbing area
     * @param climbingArea
     * @return
     */
    @Override
    public void createClimbingArea(ClimbingArea climbingArea) {
        String sql = "INSERT INTO public.climbingArea (member_id, name, region, description, profil, rock_type, maximum_height, is_approuved)"
                             + "VALUES (:memberId, :name, :region, :description, :profil, :rockType, :maximumHeight, :isApprouved)";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("name", climbingArea.getName(), Types.VARCHAR);
        parameterSource.addValue("region", climbingArea.getRegion(), Types.VARCHAR);
        parameterSource.addValue("description", climbingArea.getDescription(), Types.VARCHAR);
        parameterSource.addValue("profil", climbingArea.getProfil(), Types.VARCHAR);
        parameterSource.addValue("rockType", climbingArea.getRockType(), Types.VARCHAR);
        parameterSource.addValue("maximumHeight", climbingArea.getMaximumHeight(), Types.FLOAT);
        parameterSource.addValue("isApprouved", climbingArea.isApprouved(), Types.BOOLEAN);
        parameterSource.addValue("memberId", climbingArea.getMember().getId(), Types.INTEGER);

        namedParameterJdbcTemplate.update(sql, parameterSource);
    }

    @Override
    public ClimbingArea findClimbingArea(Integer id) {
        String sql = "SELECT * FROM public.climbingArea WHERE id = :id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id, Types.INTEGER);
        ClimbingAreaRowMapper climbingAreaRowMapper = new ClimbingAreaRowMapper();
        ClimbingArea climbingArea = namedParameterJdbcTemplate.queryForObject(sql, parameterSource, climbingAreaRowMapper);

        return climbingArea;
    }

    @Override
    public ClimbingArea findClimbingAreaByProperty(String propertyName, Object propertyValue) {
        String sql = "SELECT * FROM public.climbingArea WHERE "+propertyName+" = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        try{
            ClimbingArea climbingArea = jdbcTemplate.queryForObject(sql, new ClimbingAreaRowMapper(), propertyValue);
            return climbingArea;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<ClimbingArea> findAllClimbingAreaByMemberId(Integer id) {
        String sql = "SELECT * FROM public.climbingArea WHERE member_id = :id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id, Types.INTEGER);
        ClimbingAreaRowMapper climbingAreaRowMapper = new ClimbingAreaRowMapper();
        List<ClimbingArea> climbingAreaList = namedParameterJdbcTemplate.query(sql, parameterSource, climbingAreaRowMapper);

        return climbingAreaList;
    }

    @Override
    public void updateClimbingArea(ClimbingArea climbingArea) {
        String sql = "UPDATE public.climbingArea SET "
                + "member_id = :memberId, "
                + "name = :name, "
                + "region = :region, "
                + "description = :description, "
                + "profil = :profil, "
                + "rock_type = :rockType, "
                + "maximum_height = :maximumHeight, "
                + "is_approuved = :isApprouved "
                + "WHERE id = :id";

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", climbingArea.getId(), Types.INTEGER);
        parameterSource.addValue("name", climbingArea.getName(), Types.VARCHAR);
        parameterSource.addValue("region", climbingArea.getRegion(), Types.VARCHAR);
        parameterSource.addValue("description", climbingArea.getDescription(), Types.VARCHAR);
        parameterSource.addValue("profil", climbingArea.getProfil(), Types.VARCHAR);
        parameterSource.addValue("rockType", climbingArea.getRockType(), Types.VARCHAR);
        parameterSource.addValue("maximumHeight", climbingArea.getMaximumHeight(), Types.FLOAT);
        parameterSource.addValue("isApprouved", climbingArea.isApprouved(), Types.BOOLEAN);
        parameterSource.addValue("memberId", climbingArea.getMember().getId(), Types.INTEGER);

        namedParameterJdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public void deleteClimbingArea(Integer id) {
        String sql = "DELETE FROM public.climbingArea WHERE id = :id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);

        namedParameterJdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public List<ClimbingArea> findAllClimbingArea() {
        String sql = "SELECT * FROM public.climbingArea ORDER BY id";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        ClimbingAreaRowMapper climbingAreaRowMapper = new ClimbingAreaRowMapper();
        List<ClimbingArea> climbingAreaList = jdbcTemplate.query(sql, climbingAreaRowMapper);

        return climbingAreaList;
    }

    @Override
    public void deleteTag(Integer id) {
        String sql = "UPDATE public.climbingArea "
                + "SET is_approuved = false "
                + "WHERE id = :id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id, Types.INTEGER);
        namedParameterJdbcTemplate.update(sql, parameterSource);
    }

    @Override
    public void addTag(Integer id) {
        String sql = "UPDATE public.climbingArea "
                             + "SET is_approuved = true "
                             + "WHERE id = :id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id, Types.INTEGER);
        namedParameterJdbcTemplate.update(sql, parameterSource);
    }

    @Override
    public List<ClimbingArea> findAllClimbingAreaSearchRequest(String name, String region, String cotation, Integer numberSector) {
        String sql = "SELECT distinct climbingarea. * FROM public.climbingarea " +
                             "JOIN public.sector ON sector.climbingarea_id = climbingarea.id " +
                             "JOIN public.route ON route.sector_id = sector.id " +
                             "WHERE climbingarea.name = :name OR climbingarea.region = :region OR route.cotation = :cotation OR (SELECT COUNT(sector.id) FROM sector WHERE sector.climbingarea_id = climbingarea.id) >= :numberSector";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("name", name, Types.VARCHAR);
        parameterSource.addValue("region", region, Types.VARCHAR);
        parameterSource.addValue("cotation", cotation, Types.VARCHAR);
        ClimbingAreaRowMapper climbingAreaRowMapper = new ClimbingAreaRowMapper();
        List<ClimbingArea> climbingAreaList = namedParameterJdbcTemplate.query(sql, parameterSource, climbingAreaRowMapper);

        return climbingAreaList;
    }


}
