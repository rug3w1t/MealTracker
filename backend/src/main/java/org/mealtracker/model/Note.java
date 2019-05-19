package org.mealtracker.model;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;


@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "time")
    private Time time;

    @Column(name="textFiled")
    private String textFiled;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="user_id", nullable=false)
    private Long userId;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    public Note(){

    }

    public Note(Long id, String textFiled) {
        this.id = id;
        this.textFiled = textFiled;
    }

    public Note(String textFiled) {
        this.textFiled = textFiled;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextFiled() {
        return textFiled;
    }

    public void setTextFiled(String textFiled) {
        this.textFiled = textFiled;
    }


    public String getDescription() {
        return description;
    }

    public Time getTime() {
        return time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }
}
