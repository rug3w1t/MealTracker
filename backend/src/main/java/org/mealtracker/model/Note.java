package org.mealtracker.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "type")
    private String mealType;

    @Column(name = "time")
    private LocalTime time;

    @Column(name="description")
    private String description;

    @ManyToOne()
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    public Note(){
    }

    public Note(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public LocalTime getTime() {

        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }


    public LocalDate getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
