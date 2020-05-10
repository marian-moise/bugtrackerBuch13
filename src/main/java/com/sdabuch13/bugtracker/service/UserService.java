package com.sdabuch13.bugtracker.service;

import com.sdabuch13.bugtracker.model.HibernateUtil;
import com.sdabuch13.bugtracker.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;

public class UserService {

    public User createUser(String userName) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        User newUser = new User(userName);
        Transaction t = session.beginTransaction();
        session.save(newUser);
        t.commit();
        System.out.println(newUser);
        session.close();
        return newUser;

    }


    public User getUser(String userName) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        String queryString = "select u from User u where " + "u.userName = :userName";

        Query<User> query = session.createQuery(queryString, User.class);
        query.setParameter("userName", userName);

        User user;
        try {
            user = query.getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        } finally {
            session.close();
        }
        return user;
    }

    public List<User> findAllUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String queryString = "select u from User u";
        Query<User> query = session.createQuery(queryString, User.class);
        List<User> list = query.list();
        session.close();
        return list;
    }



    public void updateUser(int id, String newName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String updateQuery = "update User u set u.userName= :newName " +
                "where u.userId = :id";
        int update = session.createQuery(updateQuery).setParameter("id", id)
                .setParameter("newName", newName)
                .executeUpdate();
        transaction.commit();
        session.close();
    }


    public void deleteUser(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete from User u where u.userId = :id");
        q.setParameter("id",id);
        q.executeUpdate();
        transaction.commit();
        session.close();

    }

}
