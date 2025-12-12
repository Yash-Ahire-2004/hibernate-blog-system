# Hibernate Blog System

A pure Hibernate + PostgreSQL blog system with full entity relationships, DAO layer, and menu-driven CLI.

## 📦 Technologies Used

- Java 17
- Hibernate (JPA)
- PostgreSQL
- Maven
- Eclipse IDE

## 🧩 Features

- Create, read, delete Users, Posts, and Comments
- Assign relationships:
  - User → Post
  - User → Comment
  - Post → Comment
- Prevent duplicate user creation
- Menu-driven console interface
- No Spring Boot — pure Hibernate setup

## 🗂️ Entity Relationships

- One User → Many Posts  
- One User → Many Comments  
- One Post → Many Comments  
- Each Comment belongs to one User and one Post

## 🧪 Example Scenario

```text
1. Create User → yash / yash@gmail.com / 12345
2. Create Post → "My First Blog" / "This is my first post."
3. Create Comment → "Nice post!"
4. Assign User to Post → User ID: 1, Post ID: 1
5. Assign User to Comment → User ID: 1, Comment ID: 1
6. Assign Post to Comment → Post ID: 1, Comment ID: 1
7. Read Post → shows title, content, and author
8. Read Comment → shows content, author, and post
