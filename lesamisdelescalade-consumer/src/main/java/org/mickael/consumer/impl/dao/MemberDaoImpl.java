package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.MemberDao;
import org.mickael.consumer.impl.AbstractDao;
import org.mickael.consumer.impl.rowmapper.MemberRowMapper;
import org.mickael.model.bean.Member;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.sql.Types;
import java.util.List;

public class MemberDaoImpl extends AbstractDao implements MemberDao {

    @Override
    public void createMember(Member member) {
        String sql = "INSERT INTO public.member (first_name, last_name, pseudo, birthdate, gender, email, password, is_member, is_admin)"
                             + "VALUES (:firstName, :lastName, :pseudo, :birthdate, :gender, :email, :password, :isMember, :isAdmin)";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("firstName", member.getFirstName(), Types.VARCHAR);
        parameterSource.addValue("lastName", member.getLastName(), Types.VARCHAR);
        parameterSource.addValue("pseudo", member.getPseudo(), Types.VARCHAR);
        parameterSource.addValue("birthdate", member.getBirthDate(), Types.DATE);
        parameterSource.addValue("gender", member.getGender(), Types.VARCHAR);
        parameterSource.addValue("email", member.getEmail(), Types.VARCHAR);
        parameterSource.addValue("password", member.getPassword(), Types.VARCHAR);
        parameterSource.addValue("isMember", member.isMember(), Types.BOOLEAN);
        parameterSource.addValue("isAdmin", member.isAdmin(), Types.BOOLEAN);


        getNamedParameterJdbcTemplate().update(sql, parameterSource);

    }

    @Override
    public Member findMember(Integer id) {
        String sql = "SELECT * FROM public.member WHERE id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id, Types.INTEGER);
        MemberRowMapper memberRowMapper = new MemberRowMapper();
        Member member = getNamedParameterJdbcTemplate().queryForObject(sql, parameterSource, memberRowMapper);

        return member;
    }

    @Override
    public Member findMemberByMail(String email){
        String sql = "SELECT * FROM public.member WHERE email = :email";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("email", email, Types.VARCHAR);
        MemberRowMapper memberRowMapper = new MemberRowMapper();
        Member member = getNamedParameterJdbcTemplate().queryForObject(sql, parameterSource, memberRowMapper);

        return member;
    }

    @Override
    public void updateMember(Member member) {
        String sql = "UPDATE public.member SET "
                             + "first_name = :firstName, "
                             + "last_name = :lastName, "
                             + "pseudo = :pseudo, "
                             + "birthdate = :birthdate, "
                             + "gender = :gender, "
                             + "email = :email, "
                             + "password = :password, "
                             + "is_member = :isMember, "
                             + "is_admin = :isAdmin "
                             + "WHERE id = :id";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("firstName", member.getFirstName(), Types.VARCHAR);
        parameterSource.addValue("lastName", member.getLastName(), Types.VARCHAR);
        parameterSource.addValue("pseudo", member.getPseudo(), Types.VARCHAR);
        parameterSource.addValue("birthdate", member.getBirthDate(), Types.TIMESTAMP);
        parameterSource.addValue("gender", member.getGender(), Types.VARCHAR);
        parameterSource.addValue("email", member.getEmail(), Types.VARCHAR);
        parameterSource.addValue("password", member.getPassword(), Types.VARCHAR);
        parameterSource.addValue("isMember", member.isMember(), Types.BOOLEAN);
        parameterSource.addValue("isAdmin", member.isAdmin(), Types.BOOLEAN);


        getNamedParameterJdbcTemplate().update(sql, parameterSource);

    }

    @Override
    public void deleteMember(Integer id) {
        String sql = "DELETE FROM public.member WHERE id = :id";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        getNamedParameterJdbcTemplate().update(sql, parameterSource);

    }

    @Override
    public List<Member> findAllMember() {
        String sql = "SELECT * FROM public.member";
        MemberRowMapper memberRowMapper = new MemberRowMapper();
        List<Member> memberList = getJdbcTemplate().query(sql, memberRowMapper);

        return memberList;
    }
}
