package org.mealtracker.model;

import javax.persistence.*;


@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="textFiled")
    private String textFiled;

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
}
