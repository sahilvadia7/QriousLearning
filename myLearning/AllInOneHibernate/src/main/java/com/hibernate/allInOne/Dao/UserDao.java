package com.hibernate.allInOne.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.allInOne.model.Users;
import com.hibernate.allInOne.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;
import org.hibernate.Hibernate; // Import Hibernate

public class UserDao {

    public void saveUser(Users user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Start a transaction
            transaction = session.beginTransaction();
            // Save the object
            session.save(user);
            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Or, better, log the exception
            throw e; // Re-throw the exception to be handled by the caller
        }
    }

    public void updateUser(Users user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

    public Users getUserById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Users user = session.get(Users.class, id);
            if (user != null) {
                // Initialize the addresses collection while the session is open
                Hibernate.initialize(user.getAddresses());
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Users> getAllUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Users> users = session.createQuery("from Users", Users.class).list();
            for (Users user : users) {
                Hibernate.initialize(user.getAddresses());
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void deleteUser(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Users user = session.get(Users.class, id);
            if (user != null) {
                session.delete(user);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

    // Example of a join query (HQL)
    public List<Object[]> getUsersWithAddresses() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery(
                    "SELECT u.username, a.street, a.city " +
                    "FROM Users u INNER JOIN u.addresses a ", Object[].class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}

