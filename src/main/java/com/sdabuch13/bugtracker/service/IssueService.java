package com.sdabuch13.bugtracker.service;

import com.sdabuch13.bugtracker.model.HibernateUtil;
import com.sdabuch13.bugtracker.model.Issue;
import com.sdabuch13.bugtracker.model.Project;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import javax.persistence.NoResultException;

public class IssueService {

    public Issue createIssue(String issueTitle, String issueDescription) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Issue newIssue = new Issue(issueTitle, issueDescription);
        Transaction t = session.beginTransaction();
        session.save(newIssue);
        t.commit();
        System.out.println(newIssue);
        session.close();
        return newIssue;

    }

    public void addIssue(Issue issue) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(issue);
        t.commit();
        session.close();
    }


    public Issue getIssueById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Issue foundIssue = session.find(Issue.class, id);
        session.close();
        return foundIssue;
    }


    public Issue getIssueByName(String issueName) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        String queryString = "select i from Issue i where " + "i.title = :issueName";

        Query<Issue> query = session.createQuery(queryString, Issue.class);
        query.setParameter("issueName", issueName);

        Issue issue;
        try {
            issue = query.getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        } finally {
            session.close();
        }
        return issue;
    }


    public void updateIssueName(int issueId, String newTitle, String newDescription) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String updateQuery = "update Issue i set i.title= :newTitle, i.description = :newDescription " +
                " where i.issueId = :issueId";
        int update = session.createQuery(updateQuery).setParameter("issueId", issueId)
                .setParameter("newTitle", newTitle)
                .setParameter("newDescription", newDescription)
                .executeUpdate();
        transaction.commit();
        session.close();
    }


    public void deleteIssue(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete from Issue i where issueId = :id ");
        q.setParameter("id", id);
        q.executeUpdate();
        transaction.commit();
        session.close();
    }

}
