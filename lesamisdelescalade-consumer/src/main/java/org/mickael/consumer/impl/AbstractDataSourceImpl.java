package org.mickael.consumer.impl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public class AbstractDataSourceImpl {


    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
