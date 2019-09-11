package org.mickael.business.contract.manager;

import org.mickael.model.bean.ReservationRequest;

import java.util.List;

public interface ReservationRequestManager {
    void createReservationRequest(ReservationRequest reservationRequest);
    ReservationRequest findReservationRequest(Integer id);
    void updateReservationRequest(ReservationRequest reservationRequest);
    void deleteReservationRequest(Integer id);
    List<ReservationRequest> findAllReservationRequest ();
}
