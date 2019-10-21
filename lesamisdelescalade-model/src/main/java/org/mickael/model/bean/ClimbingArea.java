package org.mickael.model.bean;

import java.util.List;

public class ClimbingArea {


    //====  ATTRIBUTES  ====

    private Integer id;
    private String name;
    private String region;
    private String description;
    private String profil;
    private String rockType;
    private String holdType;
    private float maximumHeight;
    private boolean approuved;

    private Member member;
    private List<Sector> sectorList;
    private List<Photo> photoList;
    private List<Comment> commentList;
    private List<StartingPoint> startingPointList;
    private List<Parking> parkingList;



    //====  CONSTRUCTOR  ====

    public ClimbingArea() {}

    public ClimbingArea(Integer id, String name, String region, String description, String profil,
                        String rockType, String holdType, float maximumHeight,
                        boolean approuved, Member member, List<Sector> sectorList, List<Photo> photoList,
                        List<Comment> commentList, List<StartingPoint> startingPointList, List<Parking> parkingList) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.description = description;
        this.profil = profil;
        this.rockType = rockType;
        this.holdType = holdType;
        this.maximumHeight = maximumHeight;
        this.approuved = approuved;
        this.member = member;
        this.sectorList = sectorList;
        this.photoList = photoList;
        this.commentList = commentList;
        this.startingPointList = startingPointList;
        this.parkingList = parkingList;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getRockType() {
        return rockType;
    }

    public void setRockType(String rockType) {
        this.rockType = rockType;
    }

    public String getHoldType() {
        return holdType;
    }

    public void setHoldType(String holdType) {
        this.holdType = holdType;
    }

    public float getMaximumHeight() {
        return maximumHeight;
    }

    public void setMaximumHeight(float maximumHeight) {
        this.maximumHeight = maximumHeight;
    }

    public boolean isApprouved() {
        return this.approuved;
    }

    public void setApprouved(boolean approuved) {
        this.approuved = approuved;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<Sector> getSectorList() {
        return sectorList;
    }

    public void setSectorList(List<Sector> sectorList) {
        this.sectorList = sectorList;
    }

    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<StartingPoint> getStartingPointList() {
        return startingPointList;
    }

    public void setStartingPointList(List<StartingPoint> startingPointList) {
        this.startingPointList = startingPointList;
    }

    public List<Parking> getParkingList() {
        return parkingList;
    }

    public void setParkingList(List<Parking> parkingList) {
        this.parkingList = parkingList;
    }
}
