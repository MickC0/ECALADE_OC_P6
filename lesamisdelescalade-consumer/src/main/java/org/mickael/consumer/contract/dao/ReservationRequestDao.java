package org.mickael.consumer.contract.dao;

import org.mickael.model.bean.ReservationRequest;

import java.util.List;

public interface ReservationRequestDao {

    ReservationRequest createReservationRequest(ReservationRequest reservationRequest);
    ReservationRequest findReservationRequest(Integer id);
    void updateReservationRequest(ReservationRequest reservationRequest);
    void deleteReservationRequest(Integer id);
    List<ReservationRequest> findAllReservationRequest ();
}
