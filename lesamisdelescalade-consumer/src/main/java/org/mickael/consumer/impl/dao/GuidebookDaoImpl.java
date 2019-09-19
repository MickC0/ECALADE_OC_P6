package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.GuidebookDao;
import org.mickael.consumer.impl.AbstractDataSourceImpl;
import org.mickael.consumer.impl.rowmapper.GuidebookRowMapper;
import org.mickael.model.bean.Guidebook;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Types;
import java.util.List;

public class GuidebookDaoImpl extends AbstractDataSourceImpl implements GuidebookDao {

    @Override
    public void createGuidebook(Guidebook guidebook) {
        String sql = "INSERT INTO public.guidebook (member_id, name, description, added_date, is_loaned)"
                             + "VALUES (:memberId, :name, :description, :addedDAte, :isLoaned)";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("memberId", guidebook.getMember().getId(), Types.INTEGER);
        parameterSource.addValue("name", guidebook.getName(), Types.VARCHAR);
        parameterSource.addValue("description", guidebook.getDescription(), Types.VARCHAR);
        parameterSource.addValue("addedDAte", guidebook.getAddedDate(), Types.TIMESTAMP);
        parameterSource.addValue("isLoaned", guidebook.isLoaned(), Types.BOOLEAN);

        jdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public Guidebook findGuidebook(Integer id) {
        String sql = "SELECT * FROM public.guidebook"
                             + " WHERE id = " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        GuidebookRowMapper guidebookRowMapper = new GuidebookRowMapper();
        Guidebook guidebook = jdbcTemplate.queryForObject(sql, guidebookRowMapper);

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

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("memberId", guidebook.getMember().getId(), Types.INTEGER);
        parameterSource.addValue("name", guidebook.getName(), Types.VARCHAR);
        parameterSource.addValue("description", guidebook.getDescription(), Types.VARCHAR);
        parameterSource.addValue("addedDAte", guidebook.getAddedDate(), Types.TIMESTAMP);
        parameterSource.addValue("isLoaned", guidebook.isLoaned(), Types.BOOLEAN);

        jdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public void deleteGuidebook(Integer id) {
        String sql = "DELETE FROM public.guidebook WHERE id = :id";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("id", id);
        jdbcTemplate.update(sql, parameterSource);
    }

    @Override
    public List<Guidebook> findAllGuidebook() {
        String sql = "SELECT * FROM public.guidebook";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        GuidebookRowMapper guidebookRowMapper = new GuidebookRowMapper();
        List<Guidebook> guidebookList = jdbcTemplate.query(sql, guidebookRowMapper);

        return guidebookList;
    }
}
