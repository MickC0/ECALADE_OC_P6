package org.mickael.business.contract.manager;

import org.mickael.model.bean.ReservationRequest;

import java.util.List;

public interface ReservationRequestManager {
    void createReservationRequest(ReservationRequest reservationRequest);
    ReservationRequest findReservationRequestByGuidebookId(Integer id);
    ReservationRequest findReservationRequestByMemberId(Integer id);
    void updateReservationRequest(ReservationRequest reservationRequest);
    void deleteReservationRequest(Integer id);
    List<ReservationRequest> findAllReservationRequest ();
    List<ReservationRequest> findAllReservationRequestByMemberId (Integer id);
    List<ReservationRequest> findAllReservationRequestByGuidebookId (Integer id);
}
