package org.mickael.business.impl;

import org.mickael.consumer.contract.DaoFactory;
import org.springframework.transaction.PlatformTransactionManager;

import javax.inject.Named;

public abstract class AbstractManager {

    @Named("txManager")
    private PlatformTransactionManager platformTransactionManager;

    public PlatformTransactionManager getPlatformTransactionManager() {
        return platformTransactionManager;
    }

    public void setPlatformTransactionManager(PlatformTransactionManager platformTransactionManager) {
        this.platformTransactionManager = platformTransactionManager;
    }

    private DaoFactory daoFactory;

    public DaoFactory getDaoFactory() {
        return daoFactory;
    }

    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
}
