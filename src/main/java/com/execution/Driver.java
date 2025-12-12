package com.execution;

import java.time.LocalDate;
import java.util.Scanner;
import com.dao.*;
import com.entity.*;

public class Driver {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== BLOG SYSTEM MENU =====");
            System.out.println("1. Create User");
            System.out.println("2. Create Post");
            System.out.println("3. Create Comment");
            System.out.println("4. Read All Users");
            System.out.println("5. Read All Posts");
            System.out.println("6. Read All Comments");
            System.out.println("7. Read Single User");
            System.out.println("8. Read Single Post");
            System.out.println("9. Read Single Comment");
            System.out.println("10. Delete User");
            System.out.println("11. Delete Post");
            System.out.println("12. Delete Comment");
            System.out.println("13. Assign User to Post");
            System.out.println("14. Assign User to Comment");
            System.out.println("15. Assign Post to Comment");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            case 1:
                System.out.print("Username: ");
                String uname = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("Password: ");
                String pass = sc.nextLine();

                User u = new User();
                u.setUsername(uname);
                u.setEmail(email);
                u.setPassword(pass);

                System.out.println(UserDao.createUser(u));
                break;

            case 2:
                System.out.print("Title: ");
                String title = sc.nextLine();
                System.out.print("Content: ");
                String content = sc.nextLine();

                Post p = new Post();
                p.setTitle(title);
                p.setContent(content);
                p.setCreateDate(LocalDate.now());
                p.setUpdateDate(LocalDate.now());

                PostDao.createPost(p);
                System.out.println("Post created.");
                break;

            case 3:
                System.out.print("Comment content: ");
                String cmt = sc.nextLine();

                Comment c = new Comment();
                c.setContent(cmt);

                CommentDao.createComment(c);
                System.out.println("Comment created.");
                break;

            case 4:
                UserDao.getAllUsers().forEach(System.out::println);
                break;

            case 5:
                PostDao.getAllPosts().forEach(System.out::println);
                break;

            case 6:
                CommentDao.getAllComments().forEach(System.out::println);
                break;

            case 7:
                System.out.print("User ID: ");
                long uid = sc.nextLong();
                System.out.println(UserDao.getUserById(uid));
                break;

            case 8:
                System.out.print("Post ID: ");
                long pid = sc.nextLong();
                System.out.println(PostDao.getPostById(pid));
                break;

            case 9:
                System.out.print("Comment ID: ");
                long cid = sc.nextLong();
                System.out.println(CommentDao.getCommentById(cid));
                break;

            case 10:
                System.out.print("User ID to delete: ");
                long duid = sc.nextLong();
                UserDao.deleteUser(duid);
                System.out.println("User deleted.");
                break;

            case 11:
                System.out.print("Post ID to delete: ");
                long dpid = sc.nextLong();
                PostDao.deletePost(dpid);
                System.out.println("Post deleted.");
                break;

            case 12:
                System.out.print("Comment ID to delete: ");
                long dcid = sc.nextLong();
                CommentDao.deleteComment(dcid);
                System.out.println("Comment deleted.");
                break;

            case 13:
                System.out.print("User ID: ");
                long auid = sc.nextLong();
                System.out.print("Post ID: ");
                long apid = sc.nextLong();
                PostDao.assignUserToPost(auid, apid);
                System.out.println("User assigned to Post.");
                break;

            case 14:
                System.out.print("User ID: ");
                long cuid = sc.nextLong();
                System.out.print("Comment ID: ");
                long ccid = sc.nextLong();
                CommentDao.assignUserToComment(cuid, ccid);
                System.out.println("User assigned to Comment.");
                break;

            case 15:
                System.out.print("Post ID: ");
                long cpId = sc.nextLong();
                System.out.print("Comment ID: ");
                long cmId = sc.nextLong();
                CommentDao.assignPostToComment(cpId, cmId);
                System.out.println("Post assigned to Comment.");
                break;

            case 0:
                System.out.println("Exiting...");
                sc.close();
                return;

            default:
                System.out.println("Invalid choice.");
            }
        }
    }
}