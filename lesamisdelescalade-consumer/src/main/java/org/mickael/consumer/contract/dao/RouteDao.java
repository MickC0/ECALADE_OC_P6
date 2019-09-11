package org.mickael.consumer.contract.dao;

import org.mickael.model.bean.Route;

import java.util.List;

public interface RouteDao {

    void createRoute(Route route);
    Route findRoute(Integer id);
    void updateRoute(Route route);
    void deleteRoute(Integer id);
    List<Route> findAllRoute ();
}
