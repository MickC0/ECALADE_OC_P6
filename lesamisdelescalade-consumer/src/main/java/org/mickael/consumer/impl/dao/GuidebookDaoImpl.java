package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.GuidebookDao;
import org.mickael.consumer.impl.AbstractDataSource;
import org.mickael.consumer.impl.rowmapper.GuidebookRowMapper;
import org.mickael.model.bean.Guidebook;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Types;
import java.util.List;

public class GuidebookDaoImpl extends AbstractDataSource implements GuidebookDao {

    @Override
    public void createGuidebook(Guidebook guidebook) {
        String sql = "INSERT INTO public.guidebook (member_id, name, description, added_date, is_loaned)"
                             + "VALUES (:memberId, :name, :description, :addedDAte, :isLoaned)";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("memberId", guidebook.getMember().getId(), Types.INTEGER);
        parameterSource.addValue("name", guidebook.getName(), Types.VARCHAR);
        parameterSource.addValue("description", guidebook.getDescription(), Types.VARCHAR);
        parameterSource.addValue("addedDAte", guidebook.getAddedDate(), Types.TIMESTAMP);
        parameterSource.addValue("isLoaned", guidebook.isLoaned(), Types.BOOLEAN);

        namedParameterJdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public Guidebook findGuidebook(Integer id) {
        String sql = "SELECT * FROM public.guidebook WHERE id = :id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id, Types.INTEGER);
        GuidebookRowMapper guidebookRowMapper = new GuidebookRowMapper();
        Guidebook guidebook = namedParameterJdbcTemplate.queryForObject(sql, parameterSource, guidebookRowMapper);

        return guidebook;
    }

    @Override
    public Guidebook findGuidebookByProperty(String propertyName, Object propertyValue) {
        String sql = "SELECT * FROM public.guidebook WHERE "+propertyName+" = :"+propertyName+"";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue(propertyName, propertyValue);
        Guidebook guidebook = namedParameterJdbcTemplate.queryForObject(sql, parameterSource, new GuidebookRowMapper());
        return guidebook;
    }

    @Override
    public void updateGuidebook(Guidebook guidebook) {
        String sql = "UPDATE public.guidebook SET "
                             + "member_id = :memberId, "
                             + "name = :name, "
                             + "description = :description, "
                             + "added_date = :addedDate, "
                             + "is_loaned = :isLoaned "
                             + "WHERE id = :id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", guidebook.getId(), Types.INTEGER);
        parameterSource.addValue("memberId", guidebook.getMember().getId(), Types.INTEGER);
        parameterSource.addValue("name", guidebook.getName(), Types.VARCHAR);
        parameterSource.addValue("description", guidebook.getDescription(), Types.VARCHAR);
        parameterSource.addValue("addedDate", guidebook.getAddedDate(), Types.DATE);
        parameterSource.addValue("isLoaned", guidebook.isLoaned(), Types.BOOLEAN);

        namedParameterJdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public void deleteGuidebook(Integer id) {
        String sql = "DELETE FROM public.guidebook WHERE id = :id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        namedParameterJdbcTemplate.update(sql, parameterSource);
    }

    @Override
    public List<Guidebook> findAllGuidebook() {
        String sql = "SELECT * FROM public.guidebook";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        GuidebookRowMapper guidebookRowMapper = new GuidebookRowMapper();
        List<Guidebook> guidebookList = jdbcTemplate.query(sql, guidebookRowMapper);

        return guidebookList;
    }

    @Override
    public List<Guidebook> findAllGuidebookByMemberId(Integer id) {
        String sql = "SELECT * FROM public.guidebook WHERE member_id = :id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        GuidebookRowMapper guidebookRowMapper = new GuidebookRowMapper();
        List<Guidebook> guidebookList = namedParameterJdbcTemplate.query(sql, parameterSource, guidebookRowMapper);

        return guidebookList;
    }
}
