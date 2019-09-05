package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.RouteDao;
import org.mickael.consumer.impl.AbstractDataSourceImpl;
import org.mickael.model.bean.Route;

import java.util.List;

public class RouteDaoImpl  extends AbstractDataSourceImpl implements RouteDao {

    @Override
    public Route createRoute(Route route) {
        return null;
    }

    @Override
    public Route findRoute(Integer id) {
        return null;
    }

    @Override
    public void updateRoute(Route route) {

    }

    @Override
    public void deleteRoute(Integer id) {

    }

    @Override
    public List<Route> findAllRoute() {
        return null;
    }
}
