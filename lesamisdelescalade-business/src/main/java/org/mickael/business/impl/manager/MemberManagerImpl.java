package org.mickael.business.impl.manager;

import org.mickael.business.contract.manager.MemberManager;
import org.mickael.business.impl.AbstractManager;
import org.mickael.model.bean.Member;

import java.util.List;

public class MemberManagerImpl extends AbstractManager implements MemberManager {
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
