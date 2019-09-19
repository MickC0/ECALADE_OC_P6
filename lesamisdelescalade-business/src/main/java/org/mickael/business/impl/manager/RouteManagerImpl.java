package org.mickael.business.impl.manager;

import org.mickael.business.contract.manager.RouteManager;
import org.mickael.business.impl.AbstractManager;
import org.mickael.model.bean.Route;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;

public class RouteManagerImpl extends AbstractManager implements RouteManager {
    @Override
    public void createRoute(Route route) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getRouteDao().createRoute(route);
            }
        });
    }

    @Override
    public Route findRoute(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        Route route = transactionTemplate.execute(transactionStatus -> {
            Route routeTransaction;
            routeTransaction = getDaoFactory().getRouteDao().findRoute(id);
            return routeTransaction;
        });

        return route;
    }

    @Override
    public void updateRoute(Route route) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getRouteDao().updateRoute(route);
            }
        });

    }

    @Override
    public void deleteRoute(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getRouteDao().deleteRoute(id);
            }
        });

    }

    @Override
    public List<Route> findAllRoute() {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());

        List<Route> routeList = transactionTemplate.execute(transactionStatus -> {
            List<Route> routeListTransaction = new ArrayList<>();
            routeListTransaction = getDaoFactory().getRouteDao().findAllRoute();
            return  routeListTransaction;
        });

        return routeList;
    }
}
