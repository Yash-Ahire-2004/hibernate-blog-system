package com.entity;

import javax.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"comments"})
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postid;

    private String title;
    private String content;

    private LocalDate createDate;
    private LocalDate updateDate;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;
}