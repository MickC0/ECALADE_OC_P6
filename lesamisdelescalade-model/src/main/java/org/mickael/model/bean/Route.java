package org.mickael.model.bean;

public class Route {

    //====  ATTRIBUTES  ====

    private	Integer id;
    private String name;
    private String description;
    private String cotation;
    private float height;

    private Sector sector;

    //====  CONSTRUCTOR  ====

    public Route() {}

    public Route(Integer id, String name, String description,
                 String cotation, float height, Sector sector) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cotation = cotation;
        this.height = height;
        this.sector = sector;
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

    public String getCotation() {
        return cotation;
    }

    public void setCotation(String cotation) {
        this.cotation = cotation;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
}
