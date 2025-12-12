package com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import com.entity.Comment;
import com.entity.Post;
import com.entity.User;
import com.util.Connection;

public class CommentDao {

    public static void createComment(Comment c) {
        EntityManager em = Connection.getEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
    }

    public static Comment getCommentById(Long id) {
        EntityManager em = Connection.getEntityManager();
        Comment c = em.find(Comment.class, id);
        em.close();
        return c;
    }

    public static List<Comment> getAllComments() {
        EntityManager em = Connection.getEntityManager();
        List<Comment> list = em.createQuery("SELECT c FROM Comment c", Comment.class).getResultList();
        em.close();
        return list;
    }

    public static void deleteComment(Long id) {
        EntityManager em = Connection.getEntityManager();
        Comment c = em.find(Comment.class, id);
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
        em.close();
    }

    public static void assignUserToComment(Long userId, Long commentId) {
        EntityManager em = Connection.getEntityManager();

        User user = em.find(User.class, userId);
        Comment comment = em.find(Comment.class, commentId);

        comment.setUser(user);

        em.getTransaction().begin();
        em.merge(comment);
        em.getTransaction().commit();
        em.close();
    }

    public static void assignPostToComment(Long postId, Long commentId) {
        EntityManager em = Connection.getEntityManager();

        Post post = em.find(Post.class, postId);
        Comment comment = em.find(Comment.class, commentId);

        comment.setPost(post);

        em.getTransaction().begin();
        em.merge(comment);
        em.getTransaction().commit();
        em.close();
    }
}