package com.codehub.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="title")
    private String title ;
    @Column(nullable = false,name="nickname",unique = true)
    private String nickname;

    @Column(nullable = false,length = 2500,name="content")
    private String content;

    @Column(name="upvotes")
     private Integer upvotes=0;

    @Column(name="createdAt")
     private LocalDateTime createdAt;

     @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id",nullable = false)
    private Section section;

     @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true)
     private List<Comments> comments;

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }
}
