package org.mickael.business.contract.manager;

import org.mickael.model.bean.Sector;

import java.util.List;

public interface SectorManager {
    void createSector(Sector sector);
    Sector findSector(Integer id);
    void updateSector(Sector sector);
    void deleteSector(Integer id);
    List<Sector> findAllSector ();
}
