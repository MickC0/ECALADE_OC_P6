package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.StartingPointDao;
import org.mickael.consumer.impl.AbstractDataSourceImpl;
import org.mickael.model.bean.StartingPoint;

import java.util.List;

public class StartingPointDaoImpl extends AbstractDataSourceImpl implements StartingPointDao {

    @Override
    public StartingPoint createStartingPoint(StartingPoint startingPoint) {
        return null;
    }

    @Override
    public StartingPoint findStartingPoint(Integer id) {
        return null;
    }

    @Override
    public void updateStartingPoint(StartingPoint startingPoint) {

    }

    @Override
    public void deleteStartingPoint(Integer id) {

    }

    @Override
    public List<StartingPoint> findAllStartingPoint() {
        return null;
    }
}
