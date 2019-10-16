package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.GuidebookDao;
import org.mickael.consumer.impl.AbstractDao;
import org.mickael.consumer.impl.rowmapper.GuidebookRowMapper;
import org.mickael.model.bean.Guidebook;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.sql.Types;
import java.util.List;

public class GuidebookDaoImpl extends AbstractDao implements GuidebookDao {

    @Override
    public void createGuidebook(Guidebook guidebook) {
        String sql = "INSERT INTO public.guidebook (member_id, name, description, added_date, is_loaned)"
                             + "VALUES (:memberId, :name, :description, :addedDAte, :isLoaned)";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("memberId", guidebook.getMember().getId(), Types.INTEGER);
        parameterSource.addValue("name", guidebook.getName(), Types.VARCHAR);
        parameterSource.addValue("description", guidebook.getDescription(), Types.VARCHAR);
        parameterSource.addValue("addedDAte", guidebook.getAddedDate(), Types.TIMESTAMP);
        parameterSource.addValue("isLoaned", guidebook.isLoaned(), Types.BOOLEAN);

        getNamedParameterJdbcTemplate().update(sql, parameterSource);

    }

    @Override
    public Guidebook findGuidebook(Integer id) {
        String sql = "SELECT * FROM public.guidebook WHERE id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id, Types.INTEGER);
        GuidebookRowMapper guidebookRowMapper = new GuidebookRowMapper();
        Guidebook guidebook = getNamedParameterJdbcTemplate().queryForObject(sql, parameterSource, guidebookRowMapper);

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

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("memberId", guidebook.getMember().getId(), Types.INTEGER);
        parameterSource.addValue("name", guidebook.getName(), Types.VARCHAR);
        parameterSource.addValue("description", guidebook.getDescription(), Types.VARCHAR);
        parameterSource.addValue("addedDAte", guidebook.getAddedDate(), Types.TIMESTAMP);
        parameterSource.addValue("isLoaned", guidebook.isLoaned(), Types.BOOLEAN);

        getNamedParameterJdbcTemplate().update(sql, parameterSource);

    }

    @Override
    public void deleteGuidebook(Integer id) {
        String sql = "DELETE FROM public.guidebook WHERE id = :id";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("id", id);
        getNamedParameterJdbcTemplate().update(sql, parameterSource);
    }

    @Override
    public List<Guidebook> findAllGuidebook() {
        String sql = "SELECT * FROM public.guidebook";
        GuidebookRowMapper guidebookRowMapper = new GuidebookRowMapper();
        List<Guidebook> guidebookList = getJdbcTemplate().query(sql, guidebookRowMapper);

        return guidebookList;
    }
}
