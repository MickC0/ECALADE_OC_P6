package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.MemberDao;
import org.mickael.consumer.impl.AbstractDataSourceImpl;
import org.mickael.model.bean.Member;

import java.util.List;

public class MemberDaoImpl extends AbstractDataSourceImpl implements MemberDao {

    @Override
    public void createMember(Member member) {

    }

    @Override
    public Member findMember(Integer id) {
        return null;
    }

    @Override
    public void updateMember(Member member) {

    }

    @Override
    public void deleteMember(Integer id) {

    }

    @Override
    public List<Member> findAllMember() {
        return null;
    }
}
