package org.mickael.consumer.contract.dao;

import org.mickael.model.bean.Photo;

import java.util.List;

public interface PhotoDao {

    void createPhoto(Photo photo);
    Photo findPhoto(Integer id);
    void updatePhoto(Photo photo);
    void deletePhoto(Integer id);
    List<Photo> findAllPhoto ();
    List<Photo> findAllPhotoByClimbingAreaId(Integer id);
}
