package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.PhotoDao;
import org.mickael.consumer.impl.AbstractDataSource;
import org.mickael.consumer.impl.rowmapper.PhotoRowMapper;
import org.mickael.model.bean.Photo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Types;
import java.util.List;

public class PhotoDaoImpl extends AbstractDataSource implements PhotoDao {

    @Override
    public void createPhoto(Photo photo) {
        String sql = "INSERT INTO public.photo (climbingarea_id, name, url)"
                             + "VALUES (:climbingareaId, :name, :url)";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("climbingareaId", photo.getClimbingArea().getId(), Types.INTEGER);
        parameterSource.addValue("name", photo.getName(), Types.VARCHAR);
        parameterSource.addValue("url", photo.getUrl(), Types.VARCHAR);


        namedParameterJdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public Photo findPhoto(Integer id) {
        String sql = "SELECT * FROM public.photo WHERE id = :id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id, Types.INTEGER);
        PhotoRowMapper photoRowMapper = new PhotoRowMapper();
        Photo photo = namedParameterJdbcTemplate.queryForObject(sql, parameterSource, photoRowMapper);

        return photo;
    }

    @Override
    public void updatePhoto(Photo photo) {
        String sql = "UPDATE public.photo SET "
                             + "climbingarea_id = :climbingAreaId, "
                             + "name = :name, "
                             + "url = :url "
                             + "WHERE id = :id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", photo.getId(), Types.INTEGER);
        parameterSource.addValue("climbingareaId", photo.getClimbingArea().getId(), Types.INTEGER);
        parameterSource.addValue("name", photo.getName(), Types.VARCHAR);
        parameterSource.addValue("url", photo.getUrl(), Types.VARCHAR);


        namedParameterJdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public void deletePhoto(Integer id) {
        String sql = "DELETE FROM public.photo WHERE id = :id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("id", id);
        namedParameterJdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public List<Photo> findAllPhoto() {
        String sql = "SELECT * FROM public.photo ORDER BY id";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        PhotoRowMapper photoRowMapper = new PhotoRowMapper();
        List<Photo> photoList = jdbcTemplate.query(sql, photoRowMapper);

        return photoList;
    }

    @Override
    public List<Photo> findAllPhotoByClimbingAreaId(Integer id) {
        String sql = "SELECT FROM public.photo WHERE climbingarea_id = :id ORDER BY id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("id", id);
        namedParameterJdbcTemplate.update(sql, parameterSource);
        PhotoRowMapper photoRowMapper = new PhotoRowMapper();
        List<Photo> photoList = namedParameterJdbcTemplate.query(sql, parameterSource, photoRowMapper);

        return photoList;
    }
}
