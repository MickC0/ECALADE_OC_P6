package org.mickael.business.impl.manager;

import org.mickael.business.contract.manager.GuidebookManager;
import org.mickael.business.impl.AbstractManager;
import org.mickael.model.bean.Guidebook;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;

public class GuidebookManagerImpl extends AbstractManager implements GuidebookManager {
    @Override
    public void createGuidebook(Guidebook guidebook) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getGuidebookDao().createGuidebook(guidebook);
            }
        });
    }

    @Override
    public Guidebook findGuidebook(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        Guidebook guidebook = transactionTemplate.execute(transactionStatus -> {
            Guidebook guidebookTransaction;
            guidebookTransaction = getDaoFactory().getGuidebookDao().findGuidebook(id);
            return guidebookTransaction;
        });

        return guidebook;
    }

    @Override
    public void updateGuidebook(Guidebook guidebook) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getGuidebookDao().updateGuidebook(guidebook);
            }
        });

    }

    @Override
    public void deleteGuidebook(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getGuidebookDao().deleteGuidebook(id);
            }
        });

    }

    @Override
    public List<Guidebook> findAllGuidebook() {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());

        List<Guidebook> guidebookList = transactionTemplate.execute(transactionStatus -> {
            List<Guidebook> guidebookListTransaction = new ArrayList<>();
            guidebookListTransaction = getDaoFactory().getGuidebookDao().findAllGuidebook();
            return  guidebookListTransaction;
        });

        return guidebookList;
    }
}
