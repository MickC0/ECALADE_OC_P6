package org.mickael.model.bean;

public class Parking {

    //====  ATTRIBUTES  ====

    private Integer id;
    private String name;
    private String latitude;
    private String longitude;

    private ClimbingArea climbingArea;

    //====  CONSTRUCTOR  ====

    public Parking() {}

    public Parking(Integer id, String name, String latitude, String longitude, ClimbingArea climbingArea) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.climbingArea = climbingArea;
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public ClimbingArea getClimbingArea() {
        return climbingArea;
    }

    public void setClimbingArea(ClimbingArea climbingArea) {
        this.climbingArea = climbingArea;
    }
}
