package org.mickael.consumer.contract.dao;

import org.mickael.model.bean.Guidebook;

import java.util.List;

public interface GuidebookDao {

    void createGuidebook(Guidebook guidebook);
    Guidebook findGuidebook(Integer id);
    Guidebook findGuidebookByProperty(String propertyName, Object propertyValue);
    void updateGuidebook(Guidebook guidebook);
    void deleteGuidebook(Integer id);

    List<Guidebook> findAllGuidebook ();
    List<Guidebook> findAllGuidebookByMemberId(Integer id);

}
