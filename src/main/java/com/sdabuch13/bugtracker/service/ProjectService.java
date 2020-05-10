package com.sdabuch13.bugtracker.service;

import com.sdabuch13.bugtracker.model.HibernateUtil;
import com.sdabuch13.bugtracker.model.Project;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;

public class ProjectService {


    public Project createProject(String projectName, String projectIdentifier) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Project myNewProject = new Project(projectName, projectIdentifier);
        Transaction t = session.beginTransaction();
        session.save(myNewProject);
        t.commit();
        System.out.println(myNewProject);
        session.close();
        return myNewProject;

    }


    public Project getProjectById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Project foundProject = session.find(Project.class, id);
        session.close();
        return foundProject;
    }


    public Project getProjectByName(String projectName) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        String queryString = "select p from Project p where " + "p.name = :name";

        Query<Project> query = session.createQuery(queryString, Project.class);
        query.setParameter("name", projectName);

        Project project;
        try {
            project = query.getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        } finally {
            session.close();
        }
        return project;
    }


    public void updateProjectByName(String projectName, String projectIdentifier, String projectDescription, String newName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String updateQuery = "update Project p set p.name= :newName, p.identifier = :newIdentifier, " +
                "p.description= :newDescription where p.name = :projectName";
        int update = session.createQuery(updateQuery).setParameter("projectName", projectName)
                .setParameter("newIdentifier", projectIdentifier)
                .setParameter("newDescription", projectDescription)
                .setParameter("newName", newName)
                .executeUpdate();
        transaction.commit();
        session.close();
    }


    public void deleteProjectID(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete from Project p where projectId = :id ");
        q.setParameter("id", id);
        q.executeUpdate();
        transaction.commit();
        session.close();

    }

}
