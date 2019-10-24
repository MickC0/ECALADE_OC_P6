package org.mickael.consumer.impl;



import javax.sql.DataSource;

public abstract class AbstractDataSource {


    private DataSource dataSource;

    protected DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
