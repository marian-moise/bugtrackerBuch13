package com.sdabuch13.bugtracker.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "issue")
public class Issue {

    public Issue() {
    }

    public Issue( String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Issue(String title, String description, Project projectId) {
        this.title = title;
        this.description = description;
        this.projectId = projectId;
    }

    public Issue(int issueId) {
        this.issueId = issueId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issueId")
    public int issueId;

    @Column(name = "title")
    public String title;

    @Column(name = "description")
    public String description;

    @Column(name = "dateCreated")
    public Date dateCreated;

    @ManyToOne
    @JoinColumn(name = "projectId")
    public Project projectId;

    @ManyToOne
    @JoinColumn(name = "statusId")
    public Status statusId;

    @ManyToOne
    @JoinColumn(name = "submitterId")
    public User userId;

    @ManyToOne
    @JoinColumn(name = "typeId")
    public Type typeId;

    @Override
    public String toString() {
        return "Issue{" +
                "issueId=" + issueId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateCreated=" + dateCreated +
                ", projectId=" + projectId +
                ", statusId=" + statusId +
                ", submitterId=" + userId +
                ", typeId=" + typeId +
                '}';
    }
}
