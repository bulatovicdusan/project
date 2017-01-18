package com.example.dusan.food.model;

import java.util.List;

/**
 * Created by wubon on 8/16/2016.
 */
public class Tag {

    private int id;
    private String name;
    private List<Meal> meals;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

}
