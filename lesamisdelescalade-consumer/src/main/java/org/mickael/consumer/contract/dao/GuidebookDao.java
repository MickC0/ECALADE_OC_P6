package org.mickael.consumer.contract.dao;

import org.mickael.model.bean.Guidebook;

import java.util.List;

public interface GuidebookDao {

    Guidebook createGuidebook(Guidebook guidebook);
    Guidebook findGuidebook(Integer id);
    void updateGuidebook(Guidebook guidebook);
    void deleteGuidebook(Integer id);
    List<Guidebook> findAllGuidebook ();

}
