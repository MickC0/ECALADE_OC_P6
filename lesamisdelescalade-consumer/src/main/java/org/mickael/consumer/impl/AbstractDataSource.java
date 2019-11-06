package org.mickael.consumer.impl;



import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public abstract class AbstractDataSource {

    @Inject
    @Named("dataSource")
    private static DataSource dataSource;

    protected DataSource getDataSource() {
        return dataSource;
    }

    public static void setDataSource(DataSource dataSource) {
        AbstractDataSource.dataSource = dataSource;
    }
}
