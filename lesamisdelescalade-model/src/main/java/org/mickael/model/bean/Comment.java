package org.mickael.model.bean;

import java.sql.Timestamp;

public class Comment {

    //====  ATTRIBUTES  ====

    private Integer id;
    private String description;
    private Timestamp creationDate;
    private Timestamp updateDate;

    private Member member;
    private ClimbingArea climbingArea;

    //====  CONSTRUCTOR  ====

    public Comment() {}

    public Comment(Integer id, String description, Timestamp creationDate, Timestamp updateDate, Member member, ClimbingArea climbingArea) {
        this.id = id;
        this.description = description;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.member = member;
        this.climbingArea = climbingArea;
    }

    //====  GETTERS AND SETTERS  ====


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public ClimbingArea getClimbingArea() {
        return climbingArea;
    }

    public void setClimbingArea(ClimbingArea climbingArea) {
        this.climbingArea = climbingArea;
    }
}
