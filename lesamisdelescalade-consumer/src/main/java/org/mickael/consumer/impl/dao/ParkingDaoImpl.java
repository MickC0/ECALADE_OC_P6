package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.ParkingDao;
import org.mickael.consumer.impl.AbstractDataSourceImpl;
import org.mickael.model.bean.Parking;

import java.util.List;

public class ParkingDaoImpl extends AbstractDataSourceImpl implements ParkingDao {

    @Override
    public void createParking(Parking parking) {

    }

    @Override
    public Parking findParking(Integer id) {
        return null;
    }

    @Override
    public void updateParking(Parking parking) {

    }

    @Override
    public void deleteParking(Integer id) {

    }

    @Override
    public List<Parking> findAllParking() {
        return null;
    }
}
