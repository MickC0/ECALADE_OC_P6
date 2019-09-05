package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.SectorDao;
import org.mickael.consumer.impl.AbstractDataSourceImpl;
import org.mickael.model.bean.Sector;

import java.util.List;

public class SectorDaoImpl extends AbstractDataSourceImpl implements SectorDao {

    @Override
    public Sector createSector(Sector sector) {
        return null;
    }

    @Override
    public Sector findSector(Integer id) {
        return null;
    }

    @Override
    public void updateSector(Sector sector) {

    }

    @Override
    public void deleteSector(Integer id) {

    }

    @Override
    public List<Sector> findAllSector() {
        return null;
    }
}
