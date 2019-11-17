package org.mickael.business.impl.manager;

import org.mickael.business.contract.manager.SectorManager;
import org.mickael.business.impl.AbstractManager;
import org.mickael.model.bean.Sector;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;

public class SectorManagerImpl extends AbstractManager implements SectorManager {
    @Override
    public void createSector(Sector sector) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getSectorDao().createSector(sector);
            }
        });
    }

    @Override
    public Sector findSector(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        Sector sector = transactionTemplate.execute(transactionStatus -> {
            Sector sectorTransaction;
            sectorTransaction = getDaoFactory().getSectorDao().findSector(id);
            return sectorTransaction;
        });

        return sector;
    }

    @Override
    public void updateSector(Sector sector) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getSectorDao().updateSector(sector);
            }
        });

    }

    @Override
    public void deleteSector(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getSectorDao().deleteSector(id);
            }
        });

    }

    @Override
    public List<Sector> findAllSector() {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());

        List<Sector> sectorList = transactionTemplate.execute(transactionStatus -> {
            List<Sector> sectorListTransaction = new ArrayList<>();
            sectorListTransaction = getDaoFactory().getSectorDao().findAllSector();
            return  sectorListTransaction;
        });

        return sectorList;
    }

    @Override
    public List<Sector> findAllSectorByClimbingAreaId(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());

        List<Sector> sectorList = transactionTemplate.execute(transactionStatus -> {
            List<Sector> sectorListTransaction = new ArrayList<>();
            sectorListTransaction = getDaoFactory().getSectorDao().findAllSectorByClimbingAreaId(id);
            return  sectorListTransaction;
        });

        return sectorList;
    }
}
