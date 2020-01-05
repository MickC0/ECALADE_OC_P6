package org.mickael.business.impl;

import javax.inject.Named;

@Named("searchFilter")
public class SearchFilter {

    private String name;
    private String region;
    private String cotation;
    private Integer numberSector;

    public SearchFilter() {
    }

    public SearchFilter(String name, String region, String cotation, Integer numberSector) {
        this.name = name;
        this.region = region;
        this.cotation = cotation;
        this.numberSector = numberSector;
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

    public String getCotation() {
        return cotation;
    }

    public void setCotation(String cotation) {
        this.cotation = cotation;
    }

    public Integer getNumberSector() {
        return numberSector;
    }

    public void setNumberSector(Integer numberSector) {
        this.numberSector = numberSector;
    }

    @Override
    public String toString() {
        return "SearchFilter{" +
                       "name='" + name + '\'' +
                       ", region='" + region + '\'' +
                       ", cotation='" + cotation + '\'' +
                       ", numberSector=" + numberSector +
                       '}';
    }
}
