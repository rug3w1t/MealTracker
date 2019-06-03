package org.mealtracker.model.dto;

import org.mealtracker.model.User;

public class NoteDto {

    private String id;

    private String mealType;

    private String time;

    private String description;

    private User user;

    private String date;

    public NoteDto() {
    }

    public NoteDto(String id, String mealType, String time, String description, String date) {
        this.id = id;
        this.mealType = mealType;
        this.time = time;
        this.description = description;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
