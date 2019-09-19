package org.mickael.business.impl.manager;

import org.mickael.business.contract.manager.PhotoManager;
import org.mickael.business.impl.AbstractManager;
import org.mickael.model.bean.Photo;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;

public class PhotoManagerImpl extends AbstractManager implements PhotoManager {
    @Override
    public void createPhoto(Photo photo) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getPhotoDao().createPhoto(photo);
            }
        });
    }

    @Override
    public Photo findPhoto(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        Photo photo = transactionTemplate.execute(transactionStatus -> {
            Photo photoTransaction;
            photoTransaction = getDaoFactory().getPhotoDao().findPhoto(id);
            return photoTransaction;
        });

        return photo;
    }

    @Override
    public void updatePhoto(Photo photo) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getPhotoDao().updatePhoto(photo);
            }
        });

    }

    @Override
    public void deletePhoto(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getPhotoDao().deletePhoto(id);
            }
        });

    }

    @Override
    public List<Photo> findAllPhoto() {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());

        List<Photo> photoList = transactionTemplate.execute(transactionStatus -> {
            List<Photo> photoListTransaction = new ArrayList<>();
            photoListTransaction = getDaoFactory().getPhotoDao().findAllPhoto();
            return  photoListTransaction;
        });

        return photoList;
    }
}
