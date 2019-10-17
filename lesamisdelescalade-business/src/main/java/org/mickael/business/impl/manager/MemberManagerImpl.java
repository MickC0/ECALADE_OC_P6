package org.mickael.business.impl.manager;

import org.mickael.business.contract.manager.MemberManager;
import org.mickael.business.impl.AbstractManager;
import org.mickael.model.bean.Member;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;

public class MemberManagerImpl extends AbstractManager implements MemberManager {



    @Override
    public void createMember(Member member) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getMemberDao().createMember(member);
            }
        });
    }

    @Override
    public Member findMember(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        Member member = transactionTemplate.execute(transactionStatus -> {
            Member memberTransaction;
            memberTransaction = getDaoFactory().getMemberDao().findMember(id);
            return memberTransaction;
        });

        return member;
    }

    @Override
    public Member findMemberByMail(String email){
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        Member member = transactionTemplate.execute(transactionStatus -> {
            Member memberTransaction;
            memberTransaction = getDaoFactory().getMemberDao().findMemberByMail(email);
            return  memberTransaction;
        });

        return member;
    }

    @Override
    public void updateMember(Member member) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getMemberDao().updateMember(member);
            }
        });

    }

    @Override
    public void deleteMember(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getMemberDao().deleteMember(id);
            }
        });

    }

    @Override
    public List<Member> findAllMember() {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());

        List<Member> memberList = transactionTemplate.execute(transactionStatus -> {
            List<Member> memberListTransaction = new ArrayList<>();
            memberListTransaction = getDaoFactory().getMemberDao().findAllMember();
            return  memberListTransaction;
        });

        return memberList;
    }

}
