package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.ClimbingAreaDao;
import org.mickael.consumer.impl.AbstractDataSourceImpl;
import org.mickael.consumer.impl.rowmapper.ClimbingAreaRowMapper;
import org.mickael.model.bean.ClimbingArea;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Types;
import java.util.List;

public class ClimbingAreaDaoImpl extends AbstractDataSourceImpl implements ClimbingAreaDao {


    /**
     * Create a new climbing area
     * @param climbingArea
     * @return
     */
    @Override
    public void createClimbingArea(ClimbingArea climbingArea) {
        String sql = "INSERT INTO pubic.climbingArea (member_id, name, region, description, profil, rockType, holdType, maximumHeight, isApprouved, member_id)"
                             + "VALUES (:member_id, :name, :region, :description, :profil, :rockType, :holdType, :maximumHeight, :isApprouved)";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("name", climbingArea.getName(), Types.VARCHAR);
        parameterSource.addValue("region", climbingArea.getRegion(), Types.VARCHAR);
        parameterSource.addValue("description", climbingArea.getDescription(), Types.VARCHAR);
        parameterSource.addValue("profil", climbingArea.getProfil(), Types.VARCHAR);
        parameterSource.addValue("rockType", climbingArea.getRockType(), Types.VARCHAR);
        parameterSource.addValue("holdType", climbingArea.getHoldType(), Types.VARCHAR);
        parameterSource.addValue("maximumHeight", climbingArea.getMaximumHeight(), Types.FLOAT);
        parameterSource.addValue("isApprouved", climbingArea.isApprouved(), Types.BOOLEAN);
        parameterSource.addValue("member_id", climbingArea.getMember().getId(), Types.INTEGER);

        jdbcTemplate.update(sql, parameterSource);
    }

    @Override
    public ClimbingArea findClimbingArea(Integer id) {
        String sql = "SELECT * FROM public.climbingArea"
                             + "WHERE id = " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        ClimbingAreaRowMapper climbingAreaRowMapper = new ClimbingAreaRowMapper();
        ClimbingArea climbingArea = (ClimbingArea)jdbcTemplate.queryForObject(sql, climbingAreaRowMapper);

        return climbingArea;
    }

    @Override
    public void updateClimbingArea(ClimbingArea climbingArea) {

    }

    @Override
    public void deleteClimbingArea(Integer id) {

    }

    @Override
    public List<ClimbingArea> findAllClimbingArea() {
        String sql = "SELECT * FROM public.climbingArea";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        ClimbingAreaRowMapper climbingAreaRowMapper = new ClimbingAreaRowMapper();
        List<ClimbingArea> climbingAreaList = jdbcTemplate.query(sql, climbingAreaRowMapper);

        return climbingAreaList;
    }
}
