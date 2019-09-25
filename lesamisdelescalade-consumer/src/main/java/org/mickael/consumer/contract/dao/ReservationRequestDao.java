package org.mickael.consumer.contract.dao;

import org.mickael.model.bean.ReservationRequest;

import java.util.List;

public interface ReservationRequestDao {

    void createReservationRequest(ReservationRequest reservationRequest);
    ReservationRequest findReservationRequestByGuidebookId(Integer id);
    ReservationRequest findReservationRequestByMemberId(Integer id);
    void updateReservationRequest(ReservationRequest reservationRequest);
    void deleteReservationRequest(Integer id);
    List<ReservationRequest> findAllReservationRequest ();
    //TODO Reservation par membre
    //TODO Reservation par guidebook
}
