package com.sdabuch13.bugtracker.service;

import com.sdabuch13.bugtracker.model.HibernateUtil;
import com.sdabuch13.bugtracker.model.Status;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;

public class StatusService {

    public Status createStatus(String statusName) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Status newStatus = new Status(statusName);
        Transaction t = session.beginTransaction();
        session.save(newStatus);
        t.commit();
        System.out.println(newStatus);
        session.close();
        return newStatus;

    }


    public Status getStatus(String statusName) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        String queryString = "select s from Status s where " + "s.statusName = :statusName";

        Query<Status> query = session.createQuery(queryString, Status.class);
        query.setParameter("statusName", statusName);

        Status status;
        try {
            status = query.getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        } finally {
            session.close();
        }
        return status;
    }


    public void updateStatus(int id, String newName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String updateQuery = "update Status s set s.statusName= :newName " +
                "where s.statusId = :id";
        int update = session.createQuery(updateQuery).setParameter("id", id)
                .setParameter("newName", newName)
                .executeUpdate();
        transaction.commit();
        session.close();
    }


    public void deleteStatus(String statusName){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete from Status s where statusName = :statusName ");
        q.setParameter("statusName", statusName);
        q.executeUpdate();
        transaction.commit();
        session.close();

    }


}
