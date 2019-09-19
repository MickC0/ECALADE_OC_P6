package org.mickael.business.impl.manager;

import org.mickael.business.contract.manager.StartingPointManager;
import org.mickael.business.impl.AbstractManager;
import org.mickael.model.bean.StartingPoint;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;

public class StartingPointManagerImpl extends AbstractManager implements StartingPointManager {
    @Override
    public void createStartingPoint(StartingPoint startingPoint) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getStartingPointDao().createStartingPoint(startingPoint);
            }
        });
    }

    @Override
    public StartingPoint findStartingPoint(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        StartingPoint startingPoint = transactionTemplate.execute(transactionStatus -> {
            StartingPoint startingPointTransaction;
            startingPointTransaction = getDaoFactory().getStartingPointDao().findStartingPoint(id);
            return startingPointTransaction;
        });

        return startingPoint;
    }

    @Override
    public void updateStartingPoint(StartingPoint startingPoint) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getStartingPointDao().updateStartingPoint(startingPoint);
            }
        });

    }

    @Override
    public void deleteStartingPoint(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getStartingPointDao().deleteStartingPoint(id);
            }
        });

    }

    @Override
    public List<StartingPoint> findAllStartingPoint() {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());

        List<StartingPoint> startingPointList = transactionTemplate.execute(transactionStatus -> {
            List<StartingPoint> startingPointListTransaction = new ArrayList<>();
            startingPointListTransaction = getDaoFactory().getStartingPointDao().findAllStartingPoint();
            return  startingPointListTransaction;
        });

        return startingPointList;
    }
}
