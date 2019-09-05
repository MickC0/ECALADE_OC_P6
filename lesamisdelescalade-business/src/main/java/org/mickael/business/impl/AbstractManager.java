package org.mickael.business.impl;

import org.mickael.consumer.contract.DaoFactory;

public abstract class AbstractManager {

    private DaoFactory daoFactory;

    public DaoFactory getDaoFactory() {
        return daoFactory;
    }

    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
}
