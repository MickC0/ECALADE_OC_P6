package org.mickael.model.bean;

import org.mickael.model.enumeration.ReservationState;

public class ReservationRequest {

    //====  ATTRIBUTES  ====

    private Integer id;
    private Guidebook guidebook;
    private Member member;
    private ReservationState reservationState;

    //====  CONSTRUCTOR  ====

    public ReservationRequest() {}

    public ReservationRequest(Integer id, Guidebook guidebook, Member member, ReservationState reservationState) {
        this.id = id;
        this.guidebook = guidebook;
        this.member = member;
        this.reservationState = reservationState;
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

    public ReservationState getReservationState() {
        return reservationState;
    }

    public void setReservationState(ReservationState reservationState) {
        this.reservationState = reservationState;
    }
}
