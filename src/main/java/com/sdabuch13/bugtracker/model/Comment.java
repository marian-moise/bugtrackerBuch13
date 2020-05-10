package com.sdabuch13.bugtracker.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {

    public Comment() {
    }

    public Comment(int commentId) {
        this.commentId = commentId;
    }

    public Comment(String commentText) {
        this.commentText = commentText;
    }

    public Comment(int commentId, String commentText) {
        this.commentId = commentId;
        this.commentText = commentText;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentId")
    public int commentId;

    @Column(name = "commentText")
    public String commentText;

    @Column(name = "dateTimeCreated")
    public Date dateTimeCreated;

    @ManyToOne
    @JoinColumn(name = "submitterId")
    public User userId;

    @ManyToOne
    @JoinColumn(name = "issueId")
    public Issue issueId;


    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentText='" + commentText + '\'' +
                ", dateTimeCreated=" + dateTimeCreated +
                ", userId=" + userId +
                ", issueId=" + issueId +
                '}';
    }
}
