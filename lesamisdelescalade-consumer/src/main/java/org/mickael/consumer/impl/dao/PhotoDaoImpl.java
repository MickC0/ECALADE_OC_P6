package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.PhotoDao;
import org.mickael.consumer.impl.AbstractDataSourceImpl;
import org.mickael.consumer.impl.rowmapper.PhotoRowMapper;
import org.mickael.model.bean.Photo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Types;
import java.util.List;

public class PhotoDaoImpl extends AbstractDataSourceImpl implements PhotoDao {

    @Override
    public void createPhoto(Photo photo) {
        String sql = "INSERT INTO public.photo (climbingarea_id, name, url)"
                             + "VALUES (:climbingareaId, :name, :url)";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("climbingareaId", photo.getClimbingArea().getId(), Types.INTEGER);
        parameterSource.addValue("name", photo.getName(), Types.VARCHAR);
        parameterSource.addValue("url", photo.getUrl(), Types.VARCHAR);


        jdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public Photo findPhoto(Integer id) {
        String sql = "SELECT * FROM public.photo"
                             + " WHERE id = " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        PhotoRowMapper photoRowMapper = new PhotoRowMapper();
        Photo photo = jdbcTemplate.queryForObject(sql, photoRowMapper);

        return photo;
    }

    @Override
    public void updatePhoto(Photo photo) {
        String sql = "UPDATE public.photo SET "
                             + "climbingarea_id = :climbingAreaId, "
                             + "name = :name, "
                             + "url = :url "
                             + "WHERE id = :id";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("climbingareaId", photo.getClimbingArea().getId(), Types.INTEGER);
        parameterSource.addValue("name", photo.getName(), Types.VARCHAR);
        parameterSource.addValue("url", photo.getUrl(), Types.VARCHAR);


        jdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public void deletePhoto(Integer id) {
        String sql = "DELETE FROM public.photo WHERE id = :id";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("id", id);
        jdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public List<Photo> findAllPhoto() {
        String sql = "SELECT * FROM public.photo";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        PhotoRowMapper photoRowMapper = new PhotoRowMapper();
        List<Photo> photoList = jdbcTemplate.query(sql, photoRowMapper);

        return photoList;
    }
}
