package org.mickael.model.bean;

import java.util.List;

public class Sector {

    //====  ATTRIBUTES  ====

    private	Integer id;
    private String name;
    private String description;

    private ClimbingArea climbingArea;

    private List<Route> routeList;

    //====  CONSTRUCTOR  ====

    public Sector() {}

    public Sector(Integer id, String name, String description,
                  ClimbingArea climbingArea, List<Route> routeList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.climbingArea = climbingArea;
        this.routeList = routeList;
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

    public ClimbingArea getClimbingArea() {
        return climbingArea;
    }

    public void setClimbingArea(ClimbingArea climbingArea) {
        this.climbingArea = climbingArea;
    }

    public List<Route> getRouteList() {
        return routeList;
    }

    public void setRouteList(List<Route> routeList) {
        this.routeList = routeList;
    }
}
