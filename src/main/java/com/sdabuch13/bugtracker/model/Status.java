package com.sdabuch13.bugtracker.model;

import javax.persistence.*;

@Entity
@Table(name = "status")
public class Status {

    public Status() {
    }

    public Status(int statusId) {
        this.statusId = statusId;
    }

    public Status(String statusName) {
        this.statusName = statusName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statusId")
    public int statusId;

    @Column(name = "statusName")
    public String statusName;

    @Override
    public String toString() {
        return "Status{" +
                "statusId=" + statusId +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
