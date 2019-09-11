package org.mickael.business.impl.manager;

import org.mickael.business.contract.manager.ClimbingAreaManager;
import org.mickael.business.impl.AbstractManager;
import org.mickael.model.bean.ClimbingArea;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class ClimbingAreaManagerImpl extends AbstractManager implements ClimbingAreaManager {
    @Override
    public void createClimbingArea(ClimbingArea climbingArea) {

        TransactionTemplate transactionTemplate = new TransactionTemplate(getPlatformTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getClimbingAreaDao().createClimbingArea(climbingArea);
            }
        });
    }

    @Override
    public ClimbingArea findClimbingArea(Integer id) {
        return null;
    }

    @Override
    public void updateClimbingArea(ClimbingArea climbingArea) {

    }

    @Override
    public void deleteClimbingArea(Integer id) {

    }

    @Override
    public List<ClimbingArea> findAllClimbingArea() {
        return null;
    }
}
