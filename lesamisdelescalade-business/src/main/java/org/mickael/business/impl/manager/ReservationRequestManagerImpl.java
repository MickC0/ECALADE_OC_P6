package org.mickael.business.impl.manager;

import org.mickael.business.contract.manager.ReservationRequestManager;
import org.mickael.business.impl.AbstractManager;
import org.mickael.model.bean.ReservationRequest;

import java.util.List;

public class ReservationRequestManagerImpl extends AbstractManager implements ReservationRequestManager {
    @Override
    public void createReservationRequest(ReservationRequest reservationRequest) {

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
