package org.mickael.business.contract.manager;

import org.mickael.model.bean.Guidebook;

import java.util.List;

public interface GuidebookManager {
    void createGuidebook(Guidebook guidebook);
    Guidebook findGuidebook(Integer id);
    void updateGuidebook(Guidebook guidebook);
    void deleteGuidebook(Integer id);
    List<Guidebook> findAllGuidebook ();
}
