package org.mickael.consumer.impl;

import javax.sql.DataSource;

public abstract class AbstractDataSource {


    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
