package com.wigo.services.models;
import jakarta.validation.constraints.NotNull;

public class Coordinates {
    @NotNull
    private String id;
    @NotNull
    private Integer latitude;
    @NotNull
    private Integer longitude;
    private Double latitudeDelta = 0.0122;
    private Double longitudeDelta = 0.0122;
    @NotNull
    private String address;
    @NotNull
    private String title;

    protected Coordinates() {
    }

    public Coordinates(String id, Integer latitude, Integer longitude, Double latitudeDelta, Double longitudeDelta,
            String address, String title) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.latitudeDelta = latitudeDelta;
        this.longitudeDelta = longitudeDelta;
        this.address = address;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Double getLatitudeDelta() {
        return latitudeDelta;
    }

    public void setLatitudeDelta(Double latitudeDelta) {
        this.latitudeDelta = latitudeDelta;
    }

    public Double getLongitudeDelta() {
        return longitudeDelta;
    }

    public void setLongitudeDelta(Double longitudeDelta) {
        this.longitudeDelta = longitudeDelta;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
