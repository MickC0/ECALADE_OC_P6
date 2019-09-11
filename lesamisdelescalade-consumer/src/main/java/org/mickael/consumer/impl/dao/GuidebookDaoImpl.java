package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.GuidebookDao;
import org.mickael.consumer.impl.AbstractDataSourceImpl;
import org.mickael.model.bean.Guidebook;

import java.util.List;

public class GuidebookDaoImpl extends AbstractDataSourceImpl implements GuidebookDao {

    @Override
    public void createGuidebook(Guidebook guidebook) {

    }

    @Override
    public Guidebook findGuidebook(Integer id) {
        return null;
    }

    @Override
    public void updateGuidebook(Guidebook guidebook) {

    }

    @Override
    public void deleteGuidebook(Integer id) {

    }

    @Override
    public List<Guidebook> findAllGuidebook() {
        return null;
    }
}
