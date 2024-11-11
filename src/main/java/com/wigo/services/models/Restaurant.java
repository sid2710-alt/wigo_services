package com.wigo.services.models;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.wigo.services.enums.Verification;

import jakarta.validation.constraints.NotNull;

@Document(collection = "restaurant")
public class Restaurant {
    protected Restaurant() {
    }

    public Restaurant(String title, String time, String imageUrl, List<String> food, boolean pickup, boolean delivery,
            boolean isAvailable, String owner, String code, String logoUrl, int rating, String ratingCount,
            Verification verification, Coordinates coordinates) {
        this.title = title;
        this.time = time;
        this.imageUrl = imageUrl;
        this.food = food;
        this.pickup = pickup;
        this.delivery = delivery;
        this.isAvailable = isAvailable;
        this.owner = owner;
        this.code = code;
        this.logoUrl = logoUrl;
        this.rating = rating;
        this.ratingCount = ratingCount;
        this.verification = verification;
        this.coordinates = coordinates;
    }

    @Id
    private ObjectId id;
    @NotNull(message = "title can't be null")
    private String title;
    @NotNull
    private String time;
    @NotNull
    private String imageUrl;
    private List<String> food = new ArrayList<>();
    @NotNull
    private boolean pickup;
    @NotNull
    private boolean delivery;
    @NotNull
    private boolean isAvailable;
    @NotNull
    private String owner;
    @NotNull
    private String code;
    @NotNull
    private String logoUrl;
    private int rating = 3;
    private String ratingCount = "267";
    private Verification verification = Verification.PENDING;
    private String verificationMessage = "Your Restaurant is under review. We will notify you once it is verified";
    @NotNull
    private Coordinates coordinates;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id.toString();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getFood() {
        return food;
    }

    public void setFood(List<String> food) {
        this.food = food;
    }

    public boolean isPickup() {
        return pickup;
    }

    public void setPickup(boolean pickup) {
        this.pickup = pickup;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(String ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Verification getVerification() {
        return verification;
    }

    public void setVerification(Verification verification) {
        this.verification = verification;
    }

    public String getVerificationMessage() {
        return verificationMessage;
    }

    public void setVerificationMessage(String verification) {
        this.verificationMessage = verification;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
