package com.sdabuch13.bugtracker.service;

import com.sdabuch13.bugtracker.model.HibernateUtil;
import com.sdabuch13.bugtracker.model.Type;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;

public class TypeService {

    public Type createType(String typeName) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Type newtype = new Type(typeName);
        Transaction t = session.beginTransaction();
        session.save(newtype);
        t.commit();
        System.out.println(newtype);
        session.close();
        return newtype;

    }


    public Type getType(String typeName) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        String queryString = "select t from Type t where " + "t.typeName = :typeName";

        Query<Type> query = session.createQuery(queryString, Type.class);
        query.setParameter("typeName", typeName);

        Type type;
        try {
            type = query.getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        } finally {
            session.close();
        }
        return type;
    }


    public void updateType(int id, String newName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String updateQuery = "update Type t set t.typeName= :newName " +
                "where t.typeId = :id";
        int update = session.createQuery(updateQuery).setParameter("id", id)
                .setParameter("newName", newName)
                .executeUpdate();
        transaction.commit();
        session.close();
    }


    public void deleteType(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete from Type t where typeId = :id ");
        q.setParameter("id", id);
        q.executeUpdate();
        transaction.commit();
        session.close();

    }


}
