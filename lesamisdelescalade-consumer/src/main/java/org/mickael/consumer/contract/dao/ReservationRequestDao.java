package org.mickael.consumer.contract.dao;

import org.mickael.model.bean.ReservationRequest;

import java.util.List;

public interface ReservationRequestDao {

    void createReservationRequest(ReservationRequest reservationRequest);
    ReservationRequest findReservationRequestById(Integer id);
    ReservationRequest findReservationRequestByGuidebookId(Integer id);
    ReservationRequest findReservationRequestByMemberId(Integer id);
    ReservationRequest findReservationRequestByMemberAndGuidebookId(Integer memberId, Integer guidebookId);
    ReservationRequest findReservationRequestByState(String status);
    void updateReservationRequest(ReservationRequest reservationRequest);
    void deleteReservationRequest(Integer id);
    List<ReservationRequest> findAllReservationRequest ();
    List<ReservationRequest> findAllReservationRequestByMemberId (Integer id);
    List<ReservationRequest> findAllReservationRequestByGuidebookId (Integer id);
    List<ReservationRequest> findAllReservationRequestByOwnerId (Integer id);

}
