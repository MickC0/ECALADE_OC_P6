package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.ReservationRequestDao;
import org.mickael.consumer.impl.AbstractDataSourceImpl;
import org.mickael.model.bean.ReservationRequest;

import java.util.List;

public class ReservationRequestDaoImpl extends AbstractDataSourceImpl implements ReservationRequestDao {

    @Override
    public ReservationRequest createReservationRequest(ReservationRequest reservationRequest) {
        return null;
    }

    @Override
    public ReservationRequest findReservationRequest(Integer id) {
        return null;
    }

    @Override
    public void updateReservationRequest(ReservationRequest reservationRequest) {

    }

    @Override
    public void deleteReservationRequest(Integer id) {

    }

    @Override
    public List<ReservationRequest> findAllReservationRequest() {
        return null;
    }
}
