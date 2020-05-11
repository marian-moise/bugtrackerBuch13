package com.sdabuch13.bugtracker.service;

import com.sdabuch13.bugtracker.model.Comment;
import com.sdabuch13.bugtracker.model.HibernateUtil;
import com.sdabuch13.bugtracker.model.Issue;
import com.sdabuch13.bugtracker.model.Project;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class CommentService {

    public Comment createComment(String commentText) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Comment newComment = new Comment(commentText);
        Transaction t = session.beginTransaction();
        session.save(newComment);
        t.commit();
        System.out.println(newComment);
        session.close();
        return newComment;

    }


    public Comment getCommentById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Comment foundComment = session.find(Comment.class, id);
        session.close();
        return foundComment;
    }

    public List<Comment> showAllCommentsByIssueId(Issue issue) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String queryString = "select c from Comment c where c.issueId = :issue";
        Query<Comment> query = session.createQuery(queryString, Comment.class);
        query.setParameter("issue", issue);
        List<Comment> list = query.list();
        session.close();
        return list;
    }


    public void updateComment(int commentId, String newText) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String updateQuery = "update Comment c set c.commentText = :newText " +
                " where c.commentId = :commentId";
        int update = session.createQuery(updateQuery).setParameter("commentId", commentId)
                .setParameter("newText", newText)
                .executeUpdate();
        transaction.commit();
        session.close();
    }


    public void deleteComment(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete from Comment c where commentId = :id ");
        q.setParameter("id", id);
        q.executeUpdate();
        transaction.commit();
        session.close();
    }
}
