package org.mickael.business.impl.manager;

import org.mickael.business.contract.manager.ParkingManager;
import org.mickael.business.impl.AbstractManager;
import org.mickael.model.bean.Parking;

import java.util.List;

public class ParkingManagerImpl extends AbstractManager implements ParkingManager {
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
