package com.example.dusan.food.model;

import java.util.List;

/**
 * Created by wubon on 8/16/2016.
 */
public class Meal {

    private int id;
    private String name;
    private String description;
    private double price;
    private int idRest;
    private int idTag;
    private String image;


    public Meal(int id, String name, String description, double price, String image, int idRest, int idTag) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.idRest = idRest;
        this.idTag = idTag;

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIdRest() {
        return idRest;
    }

    public void setIdRest(int idRest) {
        this.idRest = idRest;
    }

    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    private List<Meal> meals;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Meal> getMeals() {
        return meals;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Meal() {
    }

    public Meal(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }


    public Meal(int id, String name, String description, double price, int idRest, int idTag) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.idRest = idRest;
        this.idTag = idTag;
    }
}
