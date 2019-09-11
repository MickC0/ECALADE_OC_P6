package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.PhotoDao;
import org.mickael.consumer.impl.AbstractDataSourceImpl;
import org.mickael.model.bean.Photo;

import java.util.List;

public class PhotoDaoImpl extends AbstractDataSourceImpl implements PhotoDao {

    @Override
    public void createPhoto(Photo photo) {

    }

    @Override
    public Photo findPhoto(Integer id) {
        return null;
    }

    @Override
    public void updatePhoto(Photo photo) {

    }

    @Override
    public void deletePhoto(Integer id) {

    }

    @Override
    public List<Photo> findAllPhoto() {
        return null;
    }
}
