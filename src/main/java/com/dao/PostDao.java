package com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import com.entity.Post;
import com.entity.User;
import com.util.Connection;

public class PostDao {

    public static void createPost(Post p) {
        EntityManager em = Connection.getEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }

    public static Post getPostById(Long id) {
        EntityManager em = Connection.getEntityManager();
        Post p = em.find(Post.class, id);
        em.close();
        return p;
    }

    public static List<Post> getAllPosts() {
        EntityManager em = Connection.getEntityManager();
        List<Post> list = em.createQuery("SELECT p FROM Post p", Post.class).getResultList();
        em.close();
        return list;
    }

    public static void deletePost(Long id) {
        EntityManager em = Connection.getEntityManager();
        Post p = em.find(Post.class, id);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        em.close();
    }

    public static void assignUserToPost(Long userId, Long postId) {
        EntityManager em = Connection.getEntityManager();

        User user = em.find(User.class, userId);
        Post post = em.find(Post.class, postId);

        post.setUser(user);

        em.getTransaction().begin();
        em.merge(post);
        em.getTransaction().commit();
        em.close();
    }
}