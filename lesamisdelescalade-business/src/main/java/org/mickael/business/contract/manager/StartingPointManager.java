package org.mickael.business.contract.manager;

import org.mickael.model.bean.StartingPoint;

import java.util.List;

public interface StartingPointManager {
    void createStartingPoint(StartingPoint startingPoint);
    StartingPoint findStartingPoint(Integer id);
    void updateStartingPoint(StartingPoint startingPoint);
    void deleteStartingPoint(Integer id);
    List<StartingPoint> findAllStartingPoint ();
}
