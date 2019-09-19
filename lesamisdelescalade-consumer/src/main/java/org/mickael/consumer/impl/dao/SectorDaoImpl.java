package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.SectorDao;
import org.mickael.consumer.impl.AbstractDataSourceImpl;
import org.mickael.consumer.impl.rowmapper.SectorRowMapper;
import org.mickael.model.bean.Sector;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Types;
import java.util.List;

public class SectorDaoImpl extends AbstractDataSourceImpl implements SectorDao {

    @Override
    public void createSector(Sector sector) {
        String sql = "INSERT INTO public.sector (climbingarea_id, name, description)"
                             + "VALUES (:climbingareaId, :name, :description)";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("climbingareaId", sector.getClimbingArea().getId(), Types.INTEGER);
        parameterSource.addValue("name", sector.getName(), Types.VARCHAR);
        parameterSource.addValue("description", sector.getDescription(), Types.VARCHAR);


        jdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public Sector findSector(Integer id) {
        String sql = "SELECT * FROM public.sector"
                             + " WHERE id = " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        SectorRowMapper sectorRowMapper = new SectorRowMapper();
        Sector sector = jdbcTemplate.queryForObject(sql, sectorRowMapper);

        return sector;
    }

    @Override
    public void updateSector(Sector sector) {
        String sql = "UPDATE public.sector SET "
                             + "climbingarea_id = :climbingAreaId, "
                             + "name = :name, "
                             + "description = :description "
                             + "WHERE id = :id";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("climbingareaId", sector.getClimbingArea().getId(), Types.INTEGER);
        parameterSource.addValue("name", sector.getName(), Types.VARCHAR);
        parameterSource.addValue("url", sector.getDescription(), Types.VARCHAR);


        jdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public void deleteSector(Integer id) {
        String sql = "DELETE FROM public.sector WHERE id = :id";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("id", id);
        jdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public List<Sector> findAllSector() {
        String sql = "SELECT * FROM public.sector";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        SectorRowMapper sectorRowMapper = new SectorRowMapper();
        List<Sector> sectorList = jdbcTemplate.query(sql, sectorRowMapper);

        return sectorList;
    }
}
