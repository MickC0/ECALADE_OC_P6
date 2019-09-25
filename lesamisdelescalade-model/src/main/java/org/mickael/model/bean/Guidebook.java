package org.mickael.model.bean;

import java.sql.Timestamp;

public class Guidebook {

    //====  ATTRIBUTES  ====

    private Integer id;
    private String name;
    private String description;
    private Timestamp addedDate;
    private boolean isLoaned;
    private String reservationStatus;

    private Member member;

    //====  CONSTRUCTOR  ====

    public Guidebook() {}

    public Guidebook(Integer id, String name, String description, Timestamp addedDate, boolean isLoaned, String reservationStatus, Member member) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.addedDate = addedDate;
        this.isLoaned = isLoaned;
        this.reservationStatus = reservationStatus;
        this.member = member;
    }

//====  GETTERS AND SETTERS  ====


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Timestamp addedDate) {
        this.addedDate = addedDate;
    }

    public boolean isLoaned() {
        return isLoaned;
    }

    public void setLoaned(boolean loaned) {
        isLoaned = loaned;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
