package com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import com.entity.User;
import com.util.Connection;

public class UserDao {

    public static String createUser(User u) {
        EntityManager em = Connection.getEntityManager();

        List<User> existing = em.createQuery(
                "SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", u.getEmail())
                .getResultList();

        if (!existing.isEmpty()) {
            em.close();
            return "User already exists";
        }

        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();

        return "User created successfully";
    }

    public static User getUserById(Long id) {
        EntityManager em = Connection.getEntityManager();
        User u = em.find(User.class, id);
        em.close();
        return u;
    }

    public static List<User> getAllUsers() {
        EntityManager em = Connection.getEntityManager();
        List<User> list = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        em.close();
        return list;
    }

    public static void deleteUser(Long id) {
        EntityManager em = Connection.getEntityManager();
        User u = em.find(User.class, id);
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
        em.close();
    }
}