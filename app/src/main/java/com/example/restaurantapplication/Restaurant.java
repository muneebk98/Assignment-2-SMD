package com.example.restaurantapplication;

public class Restaurant {
    int rating;
    String name;
    String location;
    String phone;
    String description;

    public Restaurant() {
    }

    public Restaurant(int rating, String name, String location, String phone, String description) {
        this.rating = rating;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
