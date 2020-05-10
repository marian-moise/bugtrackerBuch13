package com.sdabuch13.bugtracker.model;

import javax.persistence.*;

@Entity
@Table(name = "project")
public class Project {

    public Project() {
    }

    public Project(String name, String identifier) {
        this.name = name;
        this.identifier = identifier;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectId")
    public int projectId;

    @Column(name = "name")
    public String name;

    @Column(name = "identifier")
    public String identifier;

    @Column(name = "description")
    public String description;

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", name='" + name + '\'' +
                ", identifier='" + identifier + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
