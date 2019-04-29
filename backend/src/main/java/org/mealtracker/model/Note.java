package org.mealtracker.model;

import javax.persistence.*;
import java.sql.Time;


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

    @ManyToOne
    @JoinColumn(name="day_id", nullable=false)
    private Day day;


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

    public Day getDay() {
        return day;
    }
}
