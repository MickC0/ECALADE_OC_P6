package org.mickael.model.bean;

public class ReservationRequest {

    //====  ATTRIBUTES  ====

    private Guidebook guidebook;
    private Member member;

    //====  COONSTRUCTOR  ====

    public ReservationRequest() {}

    public ReservationRequest(Guidebook guidebook, Member member) {
        this.guidebook = guidebook;
        this.member = member;
    }

    //====  GETTERS AND SETTERS  ====


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
}
