package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.SectorDao;
import org.mickael.consumer.impl.AbstractDao;
import org.mickael.consumer.impl.rowmapper.SectorRowMapper;
import org.mickael.model.bean.Sector;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.sql.Types;
import java.util.List;

public class SectorDaoImpl extends AbstractDao implements SectorDao {

    @Override
    public void createSector(Sector sector) {
        String sql = "INSERT INTO public.sector (climbingarea_id, name, description)"
                             + "VALUES (:climbingareaId, :name, :description)";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("climbingareaId", sector.getClimbingArea().getId(), Types.INTEGER);
        parameterSource.addValue("name", sector.getName(), Types.VARCHAR);
        parameterSource.addValue("description", sector.getDescription(), Types.VARCHAR);


        getNamedParameterJdbcTemplate().update(sql, parameterSource);

    }

    @Override
    public Sector findSector(Integer id) {
        String sql = "SELECT * FROM public.sector WHERE id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id, Types.INTEGER);
        SectorRowMapper sectorRowMapper = new SectorRowMapper();
        Sector sector = getNamedParameterJdbcTemplate().queryForObject(sql, parameterSource, sectorRowMapper);

        return sector;
    }

    @Override
    public void updateSector(Sector sector) {
        String sql = "UPDATE public.sector SET "
                             + "climbingarea_id = :climbingAreaId, "
                             + "name = :name, "
                             + "description = :description "
                             + "WHERE id = :id";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("climbingareaId", sector.getClimbingArea().getId(), Types.INTEGER);
        parameterSource.addValue("name", sector.getName(), Types.VARCHAR);
        parameterSource.addValue("url", sector.getDescription(), Types.VARCHAR);


        getNamedParameterJdbcTemplate().update(sql, parameterSource);

    }

    @Override
    public void deleteSector(Integer id) {
        String sql = "DELETE FROM public.sector WHERE id = :id";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("id", id);
        getNamedParameterJdbcTemplate().update(sql, parameterSource);

    }

    @Override
    public List<Sector> findAllSector() {
        String sql = "SELECT * FROM public.sector";
        SectorRowMapper sectorRowMapper = new SectorRowMapper();
        List<Sector> sectorList = getJdbcTemplate().query(sql, sectorRowMapper);

        return sectorList;
    }
}
