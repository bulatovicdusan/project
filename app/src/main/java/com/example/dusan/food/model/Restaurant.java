package com.example.dusan.food.model;

import android.graphics.Bitmap;
import android.location.Address;

import java.net.URL;
import java.util.List;

/**
 * Created by wubon on 8/15/2016.
 */
public class Restaurant {

    private int id;
    private String name;
    private String description;
    private Bitmap smallPhoto;
    private Bitmap largePhoto;
    private Address address;
    private int startHour;
    private int startMinute;
    private int endHour;
    private int endMinute;
    private String phone;
    private String email;
    private URL site;
    private List<Meal> meals;
    private String img;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public URL getSite() {
        return site;
    }

    public void setSite(URL site) {
        this.site = site;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(int endMinute) {
        this.endMinute = endMinute;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Bitmap getLargePhoto() {
        return largePhoto;
    }

    public void setLargePhoto(Bitmap largePhoto) {
        this.largePhoto = largePhoto;
    }

    public Bitmap getSmallPhoto() {
        return smallPhoto;
    }

    public void setSmallPhoto(Bitmap smallPhoto) {
        this.smallPhoto = smallPhoto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Restaurant(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Restaurant() {
    }

    public Restaurant(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Restaurant(int id, String name, String description, String img) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.img = img;
    }
}
