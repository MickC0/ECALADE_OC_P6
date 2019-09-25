package org.mickael.model.bean;

public class ReservationRequest {

    //====  ATTRIBUTES  ====

    private Integer id;
    private Guidebook guidebook;
    private Member member;
    private boolean transactionStatus;

    //====  COONSTRUCTOR  ====

    public ReservationRequest() {}

    public ReservationRequest(Integer id, Guidebook guidebook, Member member, boolean transactionStatus) {
        this.id = id;
        this.guidebook = guidebook;
        this.member = member;
        this.transactionStatus = transactionStatus;
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

    public boolean isTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(boolean transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
