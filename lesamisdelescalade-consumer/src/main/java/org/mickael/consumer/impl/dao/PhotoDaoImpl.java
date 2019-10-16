package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.PhotoDao;
import org.mickael.consumer.impl.AbstractDao;
import org.mickael.consumer.impl.rowmapper.PhotoRowMapper;
import org.mickael.model.bean.Photo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.sql.Types;
import java.util.List;

public class PhotoDaoImpl extends AbstractDao implements PhotoDao {

    @Override
    public void createPhoto(Photo photo) {
        String sql = "INSERT INTO public.photo (climbingarea_id, name, url)"
                             + "VALUES (:climbingareaId, :name, :url)";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("climbingareaId", photo.getClimbingArea().getId(), Types.INTEGER);
        parameterSource.addValue("name", photo.getName(), Types.VARCHAR);
        parameterSource.addValue("url", photo.getUrl(), Types.VARCHAR);


        getNamedParameterJdbcTemplate().update(sql, parameterSource);

    }

    @Override
    public Photo findPhoto(Integer id) {
        String sql = "SELECT * FROM public.photo WHERE id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id, Types.INTEGER);
        PhotoRowMapper photoRowMapper = new PhotoRowMapper();
        Photo photo = getNamedParameterJdbcTemplate().queryForObject(sql, parameterSource, photoRowMapper);

        return photo;
    }

    @Override
    public void updatePhoto(Photo photo) {
        String sql = "UPDATE public.photo SET "
                             + "climbingarea_id = :climbingAreaId, "
                             + "name = :name, "
                             + "url = :url "
                             + "WHERE id = :id";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("climbingareaId", photo.getClimbingArea().getId(), Types.INTEGER);
        parameterSource.addValue("name", photo.getName(), Types.VARCHAR);
        parameterSource.addValue("url", photo.getUrl(), Types.VARCHAR);


        getNamedParameterJdbcTemplate().update(sql, parameterSource);

    }

    @Override
    public void deletePhoto(Integer id) {
        String sql = "DELETE FROM public.photo WHERE id = :id";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("id", id);
        getNamedParameterJdbcTemplate().update(sql, parameterSource);

    }

    @Override
    public List<Photo> findAllPhoto() {
        String sql = "SELECT * FROM public.photo";
        PhotoRowMapper photoRowMapper = new PhotoRowMapper();
        List<Photo> photoList = getJdbcTemplate().query(sql, photoRowMapper);

        return photoList;
    }
}
