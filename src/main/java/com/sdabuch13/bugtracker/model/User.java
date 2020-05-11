package com.sdabuch13.bugtracker.model;

import javax.persistence.*;

@Entity
@Table(name= "user")

public class User {

    public User() {
    }

    public User(int userId) {
        this.userId = userId;
    }

    public User(String userName) {
        this.userName = userName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    public int userId;

    @Column(name = "userName")
    public String userName;


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
