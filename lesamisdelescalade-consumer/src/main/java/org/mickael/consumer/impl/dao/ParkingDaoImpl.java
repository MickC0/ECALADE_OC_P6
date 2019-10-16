package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.ParkingDao;
import org.mickael.consumer.impl.AbstractDao;
import org.mickael.consumer.impl.rowmapper.ParkingRowMapper;
import org.mickael.model.bean.Parking;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.sql.Types;
import java.util.List;

public class ParkingDaoImpl extends AbstractDao implements ParkingDao {

    @Override
    public void createParking(Parking parking) {
        String sql = "INSERT INTO public.parking (climbingarea_id, name, latitude, longitude)"
                             + "VALUES (:climbingareaId, :name, :latitude, :longitude)";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("climbingareaId", parking.getClimbingArea().getId(), Types.INTEGER);
        parameterSource.addValue("name", parking.getName(), Types.VARCHAR);
        parameterSource.addValue("latitude", parking.getLatitude(), Types.VARCHAR);
        parameterSource.addValue("longitude", parking.getLongitude(), Types.VARCHAR);


        getNamedParameterJdbcTemplate().update(sql, parameterSource);

    }

    @Override
    public Parking findParking(Integer id) {
        String sql = "SELECT * FROM public.parking WHERE id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id, Types.INTEGER);
        ParkingRowMapper parkingRowMapper = new ParkingRowMapper();
        Parking parking = getNamedParameterJdbcTemplate().queryForObject(sql, parameterSource, parkingRowMapper);

        return parking;
    }

    @Override
    public void updateParking(Parking parking) {
        String sql = "UPDATE public.parking SET "
                             + "climbingarea_id = :climbingAreaId, "
                             + "name = :name, "
                             + "latitude = :latitude, "
                             + "longitude = :longitude "
                             + "WHERE id = :id";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("climbingareaId", parking.getClimbingArea().getId(), Types.INTEGER);
        parameterSource.addValue("name", parking.getName(), Types.VARCHAR);
        parameterSource.addValue("latitude", parking.getLatitude(), Types.VARCHAR);
        parameterSource.addValue("longitude", parking.getLongitude(), Types.VARCHAR);


        getNamedParameterJdbcTemplate().update(sql, parameterSource);

    }

    @Override
    public void deleteParking(Integer id) {
        String sql = "DELETE FROM public.parking WHERE id = :id";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("id", id);
        getNamedParameterJdbcTemplate().update(sql, parameterSource);

    }

    @Override
    public List<Parking> findAllParking() {
        String sql = "SELECT * FROM public.parking";
        ParkingRowMapper parkingRowMapper = new ParkingRowMapper();
        List<Parking> parkingList = getJdbcTemplate().query(sql, parkingRowMapper);

        return parkingList;
    }
}
