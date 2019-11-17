package org.mickael.consumer.contract.dao;

import org.mickael.model.bean.StartingPoint;

import java.util.List;

public interface StartingPointDao {


    void createStartingPoint(StartingPoint startingPoint);
    StartingPoint findStartingPoint(Integer id);
    void updateStartingPoint(StartingPoint startingPoint);
    void deleteStartingPoint(Integer id);
    List<StartingPoint> findAllStartingPoint ();
    List<StartingPoint> findAllStartingPointByClimbingAreaId (Integer id);
}
