package com.codehub.Entity;

import jakarta.persistence.*;

@Entity

@Table(name = "post_votes",uniqueConstraints = @UniqueConstraint(columnNames = {"postID,nickname"}))
public class PostVotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nickname",nullable = false)
    private String nickname;

    @ManyToOne
    @JoinColumn(name="post_id",nullable = false)
    private Post post;

    @Column(name = "vote_type",nullable = false)
    private Integer voteType;


    public PostVotes() {}

    public PostVotes(String nickname, Integer voteType, Post post) {
        this.nickname = nickname;
        this.voteType = voteType;
        this.post = post;
    }

    public Integer getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getVoteType() {
        return voteType;
    }

    public void setVoteType(Integer voteType) {
        this.voteType = voteType;
    }

    public Post getPosts(){
        return post;
    }
    public void setPost(Post post){
        this.post=post;
    }
}
