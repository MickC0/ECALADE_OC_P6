package org.mickael.model.bean;

public class Photo {

    //====  ATTRIBUTES  ====

    private Integer id;
    private String name;
    private String url;

    private ClimbingArea climbingArea;

    //====  CONSTRUCTOR  ====

    public Photo() {}

    public Photo(Integer id, String name, String url, ClimbingArea climbingArea) {
        this.id = id;
        this.name = name;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ClimbingArea getClimbingArea() {
        return climbingArea;
    }

    public void setClimbingArea(ClimbingArea climbingArea) {
        this.climbingArea = climbingArea;
    }
}
