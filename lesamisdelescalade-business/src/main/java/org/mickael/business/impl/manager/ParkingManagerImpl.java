package org.mickael.business.impl.manager;

import org.mickael.business.contract.manager.ParkingManager;
import org.mickael.business.impl.AbstractManager;
import org.mickael.model.bean.Parking;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;

public class ParkingManagerImpl extends AbstractManager implements ParkingManager {
    @Override
    public void createParking(Parking parking) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getParkingDao().createParking(parking);
            }
        });
    }

    @Override
    public Parking findParking(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        Parking parking = transactionTemplate.execute(transactionStatus -> {
            Parking parkingTransaction;
            parkingTransaction = getDaoFactory().getParkingDao().findParking(id);
            return parkingTransaction;
        });

        return parking;
    }

    @Override
    public void updateParking(Parking parking) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getParkingDao().updateParking(parking);
            }
        });

    }

    @Override
    public void deleteParking(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getParkingDao().deleteParking(id);
            }
        });

    }

    @Override
    public List<Parking> findAllParking() {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());

        List<Parking> parkingList = transactionTemplate.execute(transactionStatus -> {
            List<Parking> parkingListTransaction = new ArrayList<>();
            parkingListTransaction = getDaoFactory().getParkingDao().findAllParking();
            return  parkingListTransaction;
        });

        return parkingList;
    }

    @Override
    public List<Parking> findAllParkingByClimbingAreaId(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());

        List<Parking> parkingList = transactionTemplate.execute(transactionStatus -> {
            List<Parking> parkingListTransaction = new ArrayList<>();
            parkingListTransaction = getDaoFactory().getParkingDao().findAllParkingByClimbingAreaId(id);
            return  parkingListTransaction;
        });

        return parkingList;
    }
}
