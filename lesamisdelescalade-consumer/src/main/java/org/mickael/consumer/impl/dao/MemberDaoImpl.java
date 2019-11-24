package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.MemberDao;
import org.mickael.consumer.impl.AbstractDataSource;
import org.mickael.consumer.impl.rowmapper.MemberRowMapper;
import org.mickael.model.bean.Member;
import org.mickael.model.exceptions.MemberBlockedException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Types;
import java.util.List;

public class MemberDaoImpl extends AbstractDataSource implements MemberDao {





    @Override
    public void createMember(Member member) {
        String sql = "INSERT INTO public.member (first_name, last_name, pseudo, gender, email, password, role, enabled)"
                             + "VALUES (:firstName, :lastName, :pseudo, :gender, :email, :password, :role, :enabled)";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", member.getId(), Types.INTEGER);
        parameterSource.addValue("firstName", member.getFirstName(), Types.VARCHAR);
        parameterSource.addValue("lastName", member.getLastName(), Types.VARCHAR);
        parameterSource.addValue("pseudo", member.getPseudo(), Types.VARCHAR);
        parameterSource.addValue("gender", member.getGender(), Types.VARCHAR);
        parameterSource.addValue("email", member.getEmail(), Types.VARCHAR);
        parameterSource.addValue("password", member.getPassword(), Types.VARCHAR);
        parameterSource.addValue("role", member.getRole(), Types.VARCHAR);
        parameterSource.addValue("enabled", member.isEnabled(), Types.BOOLEAN);


        namedParameterJdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public Member findMember(Integer id) {
        String sql = "SELECT * FROM public.member WHERE id = :id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id, Types.INTEGER);
        MemberRowMapper memberRowMapper = new MemberRowMapper();
        Member member = namedParameterJdbcTemplate.queryForObject(sql, parameterSource, memberRowMapper);

        return member;
    }


    @Override
    public void updateMember(Member member) {
        String sql = "UPDATE public.member SET "
                             + "first_name = :firstName, "
                             + "last_name = :lastName, "
                             + "pseudo = :pseudo, "
                             + "gender = :gender, "
                             + "email = :email, "
                             + "password = :password, "
                             + "enabled = :enabled "
                             + "WHERE id = :id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("firstName", member.getFirstName(), Types.VARCHAR);
        parameterSource.addValue("lastName", member.getLastName(), Types.VARCHAR);
        parameterSource.addValue("pseudo", member.getPseudo(), Types.VARCHAR);
        parameterSource.addValue("gender", member.getGender(), Types.VARCHAR);
        parameterSource.addValue("email", member.getEmail(), Types.VARCHAR);
        parameterSource.addValue("password", member.getPassword(), Types.VARCHAR);
        parameterSource.addValue("enabled", member.isEnabled(), Types.BOOLEAN);


        namedParameterJdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public void deleteMember(Integer id) {
        String sql = "DELETE FROM public.member WHERE id = :id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        namedParameterJdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public List<Member> findAllMember() {
        String sql = "SELECT * FROM public.member";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        MemberRowMapper memberRowMapper = new MemberRowMapper();
        List<Member> memberList = jdbcTemplate.query(sql, memberRowMapper);

        return memberList;
    }

    @Override
    public Member findMemberByProperty(String propertyName, Object propertyValue) throws MemberBlockedException {
        String sql = "SELECT * FROM public.member WHERE "+propertyName+" = :"+propertyName+"";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue(propertyName, propertyValue);
        try {
            Member member = namedParameterJdbcTemplate.queryForObject(sql, parameterSource, new MemberRowMapper());
            if (member.isEnabled() == false) {
                throw new MemberBlockedException("Your account has been blocked. Contact to admin.");
            } else {
                return member;
            }
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public void changeAccountStatus(Integer id, boolean enabled) {
        String sql = "UPDATE public.member SET enabled = :enabled WHERE id = :id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        parameterSource.addValue("enabled", enabled);
        namedParameterJdbcTemplate.update(sql, parameterSource);
    }

    @Override
    public Boolean isPseudoExist(String pseudo) {
        String sql = "SELECT count(pseudo) FROM public.member WHERE pseudo = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        Integer count = jdbcTemplate.queryForObject(sql, new String[]{pseudo}, Integer.class);
        if (count == 1){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Member> findAllMemberByProperty(String propertyName, Object propertyValue) {
        String sql = "SELECT id, first_name, last_name, pseudo, email, role, enabled" +
                             " FROM public.member WHERE "+propertyName+" = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<Member> memberList = jdbcTemplate.query(sql, new MemberRowMapper(), propertyValue);
        return memberList;
    }


}
