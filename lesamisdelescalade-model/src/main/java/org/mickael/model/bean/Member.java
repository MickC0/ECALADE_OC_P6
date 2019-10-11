package org.mickael.model.bean;

import java.sql.Date;
import java.util.List;

public class Member {

    //====  ATTRIBUTES  ====

    private	Integer id;
    private String firstName;
    private String lastName;
    private String pseudo;
    private Date birthDate;
    private String gender;
    private String email;
    private String password;
    private boolean isMember;
    private boolean isAdmin;

    private List<Comment> commentList;
    private List<ClimbingArea> climbingAreaList;
    private List<Guidebook> guidebookList;

    //====  CONSTRUCTOR  ====

    public Member() {}

    public Member(Integer id, String firstName, String lastName, String pseudo, Date birthDate,
                  String gender, String email, String password, boolean isMember,
                  boolean isAdmin, List<Comment> commentList,
                  List<ClimbingArea> climbingAreaList, List<Guidebook> guidebookList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pseudo = pseudo;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.isMember = isMember;
        this.isAdmin = isAdmin;
        this.commentList = commentList;
        this.climbingAreaList = climbingAreaList;
        this.guidebookList = guidebookList;
    }

    //====  GETTERS AND SETTERS  ====


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean member) {
        isMember = member;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<ClimbingArea> getClimbingAreaList() {
        return climbingAreaList;
    }

    public void setClimbingAreaList(List<ClimbingArea> climbingAreaList) {
        this.climbingAreaList = climbingAreaList;
    }

    public List<Guidebook> getGuidebookList() {
        return guidebookList;
    }

    public void setGuidebookList(List<Guidebook> guidebookList) {
        this.guidebookList = guidebookList;
    }
}
