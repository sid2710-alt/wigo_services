package com.wigo.services.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Document(collection= "categories")
public class Category {
    @Id
    private String id;
    @NonNull
    private String title;
    @NonNull
    private String value;
    @NonNull
    private String imageUrl;

    protected Category() {}

    public Category(String id, String title, String value, String imageUrl) {
        super();
        this.id = id;
        this.title = title;
        this.value = value;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
