package org.mickael.business.impl.manager;

import org.mickael.business.contract.manager.ClimbingAreaManager;
import org.mickael.business.impl.AbstractManager;
import org.mickael.model.bean.ClimbingArea;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;

public class ClimbingAreaManagerImpl extends AbstractManager implements ClimbingAreaManager {
    @Override
    public void createClimbingArea(ClimbingArea climbingArea) {

        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getClimbingAreaDao().createClimbingArea(climbingArea);
            }
        });
    }

    @Override
    public ClimbingArea findClimbingArea(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        ClimbingArea climbingArea = transactionTemplate.execute(transactionStatus -> {
            ClimbingArea climbingAreaTransaction;
            climbingAreaTransaction = getDaoFactory().getClimbingAreaDao().findClimbingArea(id);
            return climbingAreaTransaction;
        });

        return climbingArea;

    }

    @Override
    public ClimbingArea findClimbingAreaByProperty(String propertyName, Object propertyValue) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        ClimbingArea climbingArea = transactionTemplate.execute(transactionStatus -> {
            ClimbingArea climbingAreaTransaction = new ClimbingArea();
            climbingAreaTransaction = getDaoFactory().getClimbingAreaDao().findClimbingAreaByProperty(propertyName, propertyValue);
            return  climbingAreaTransaction;
        });

        return climbingArea;
    }

    @Override
    public void updateClimbingArea(ClimbingArea climbingArea) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try{
                    getDaoFactory().getClimbingAreaDao().updateClimbingArea(climbingArea);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void deleteClimbingArea(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getClimbingAreaDao().deleteClimbingArea(id);
            }
        });
    }

    @Override
    public List<ClimbingArea> findAllClimbingArea() {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());

        List<ClimbingArea> climbingAreaList = transactionTemplate.execute(transactionStatus -> {
            List<ClimbingArea> climbingAreaListTransaction = new ArrayList<>();
            climbingAreaListTransaction = getDaoFactory().getClimbingAreaDao().findAllClimbingArea();
            return  climbingAreaListTransaction;
        });

        return climbingAreaList;

    }

    @Override
    public List<ClimbingArea> findClimbingAreaByMemberId(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        List<ClimbingArea> climbingAreaList = transactionTemplate.execute(transactionStatus -> {
            List<ClimbingArea> climbingAreaListTransaction = new ArrayList<>();
            climbingAreaListTransaction = getDaoFactory().getClimbingAreaDao().findAllClimbingAreaByMemberId(id);
            return  climbingAreaListTransaction;
        });

        return climbingAreaList;
    }

    @Override
    public List<ClimbingArea> findAllClimbingAreaSearchRequest(String name, String region, String cotation, Integer numberSector) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        List<ClimbingArea> climbingAreaList = transactionTemplate.execute(transactionStatus -> {
            List<ClimbingArea> climbingAreaListTransaction = new ArrayList<>();
            climbingAreaListTransaction = getDaoFactory().getClimbingAreaDao().findAllClimbingAreaSearchRequest(name, region, cotation, numberSector);
            return  climbingAreaListTransaction;
        });

        return climbingAreaList;
    }

    @Override
    public void deleteTag(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getClimbingAreaDao().deleteTag(id);
            }
        });
    }

    @Override
    public void addTag(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getClimbingAreaDao().addTag(id);
            }
        });
    }
}
