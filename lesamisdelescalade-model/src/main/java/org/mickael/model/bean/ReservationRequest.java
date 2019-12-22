package org.mickael.model.bean;

import org.mickael.model.enumeration.ReservationState;

public class ReservationRequest {

    //====  ATTRIBUTES  ====

    private Integer id;
    private Guidebook guidebook;
    private Member member;
    private String status;
    private ReservationState reservationState;

    //====  CONSTRUCTOR  ====

    public ReservationRequest() {}

    public ReservationRequest(Integer id, Guidebook guidebook, Member member, String status) {
        this.id = id;
        this.guidebook = guidebook;
        this.member = member;
        this.status = status;
    }

//====  GETTERS AND SETTERS  ====


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Guidebook getGuidebook() {
        return guidebook;
    }

    public void setGuidebook(Guidebook guidebook) {
        this.guidebook = guidebook;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ReservationState getReservationState() {
        return reservationState;
    }

    public void setReservationState(ReservationState reservationState) {
        this.reservationState = reservationState;
    }

    @Override
    public String toString() {
        return "ReservationRequest{" +
                       "id=" + id +
                       ", guidebook=" + guidebook +
                       ", member=" + member +
                       ", status='" + status + '\'' +
                       ", reservationState=" + reservationState +
                       '}';
    }
}
