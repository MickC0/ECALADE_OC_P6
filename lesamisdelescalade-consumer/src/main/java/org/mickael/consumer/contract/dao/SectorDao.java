package org.mickael.consumer.contract.dao;

import org.mickael.model.bean.Sector;

import java.util.List;

public interface SectorDao {


    void createSector(Sector sector);
    Sector findSector(Integer id);
    void updateSector(Sector sector);
    void deleteSector(Integer id);
    List<Sector> findAllSector ();
}
