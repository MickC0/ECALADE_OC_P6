package org.mickael.model.bean;

import org.mickael.model.enumeration.ReservationSate;

public class ReservationRequest {

    //====  ATTRIBUTES  ====

    private Integer id;
    private Guidebook guidebook;
    private Member member;
    private ReservationSate reservationState;

    //====  CONSTRUCTOR  ====

    public ReservationRequest() {}

    public ReservationRequest(Integer id, Guidebook guidebook, Member member, ReservationSate reservationState) {
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

    public ReservationSate getReservationState() {
        return reservationState;
    }

    public void setReservationState(ReservationSate reservationState) {
        this.reservationState = reservationState;
    }
}
