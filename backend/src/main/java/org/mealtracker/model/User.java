package org.mealtracker.model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name="registration_date")
    private LocalDateTime registration_date;


}
