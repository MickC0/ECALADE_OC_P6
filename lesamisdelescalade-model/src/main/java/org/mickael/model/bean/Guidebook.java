package org.mickael.model.bean;

import java.util.Date;

public class Guidebook {

    //====  ATTRIBUTES  ====

    private Integer id;
    private String name;
    private String description;
    private String region;
    private Date addedDate;
    private boolean isLoaned;

    private Member member;

    //====  CONSTRUCTOR  ====

    public Guidebook() {}

    public Guidebook(Integer id, String name, String description, String region, Date addedDate, boolean isLoaned, Member member) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.region = region;
        this.addedDate = addedDate;
        this.isLoaned = isLoaned;
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

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public boolean isLoaned() {
        return isLoaned;
    }

    public void setLoaned(boolean loaned) {
        isLoaned = loaned;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Guidebook{" +
                       "id=" + id +
                       ", name='" + name + '\'' +
                       ", description='" + description + '\'' +
                       ", region='" + region + '\'' +
                       ", addedDate=" + addedDate +
                       ", isLoaned=" + isLoaned +
                       ", member=" + member +
                       '}';
    }
}
