package org.mickael.consumer.contract.dao;

import org.mickael.model.bean.Parking;

import java.util.List;

public interface ParkingDao {

    Parking createParking(Parking parking);
    Parking findParking(Integer id);
    void updateParking(Parking parking);
    void deleteParking(Integer id);
    List<Parking> findAllParking ();
}
