package org.mickael.model.bean;

import java.sql.Date;
import java.util.List;

public class Member {

    //====  ATTRIBUTES  ====

    private	Integer id;
    private String firstName;
    private String lastName;
    private String pseudo;
    private Date birthdate;
    private String gender;
    private String email;
    private String password;
    private String role;
    private boolean enabled;

    private List<Comment> commentList;
    private List<ClimbingArea> climbingAreaList;
    private List<Guidebook> guidebookList;



    //====  CONSTRUCTOR  ====

    public Member() {}

    public Member(Integer id, String firstName, String lastName, String pseudo, Date birthdate,
                  String gender, String email, String password, String role, boolean enabled, List<Comment> commentList,
                  List<ClimbingArea> climbingAreaList, List<Guidebook> guidebookList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pseudo = pseudo;
        this.birthdate = birthdate;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

//======= toString =======


    @Override
    public String toString() {
        return "Member id= " + id + " firstName= " + firstName + " lastName= " + lastName + " pseudo= " + pseudo + " birthdate= "
                       + birthdate + " gender= " + gender + " email= " + email + " password= " + password;

    }
}
