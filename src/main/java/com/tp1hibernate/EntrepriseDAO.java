package com.tp1hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class EntrepriseDAO {

    public void insertEntreprise(Entreprise entreprise) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(entreprise);
            transaction.commit();
            System.out.println("Entreprise ajoutée : " + entreprise.getIdEntreprise());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public Entreprise findEntrepriseById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Entreprise.class, id);
        }
    }
    

    public List<Entreprise> getAllEntreprises() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Entreprise", Entreprise.class).list();
        }
    }

    public Entreprise getEntrepriseByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Entreprise WHERE nomEnt = :name", Entreprise.class)
                          .setParameter("name", name)
                          .uniqueResult();
        }
    }

    public List<Entreprise> getEntreprisesSortedByEmployees() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Entreprise ORDER BY nbEmployes DESC", Entreprise.class).list();
        }
    }

    public long getEntrepriseCount() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT COUNT(e) FROM Entreprise e", Long.class).uniqueResult();
        }
    }

    public void updateEntreprise(int id, String newName) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Entreprise entreprise = session.get(Entreprise.class, id);
            if (entreprise != null) {
                entreprise.setNomEnt(newName);
                session.update(entreprise);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deleteEntreprise(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Entreprise entreprise = session.get(Entreprise.class, id);
            if (entreprise != null) {
                session.delete(entreprise);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}

