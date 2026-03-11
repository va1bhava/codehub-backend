package com.codehub.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "comment_votes",uniqueConstraints = @UniqueConstraint(columnNames = {"comment_id,nickname"}))
public class CommentVotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nickname",nullable = false)
    private String nickname;

    @ManyToOne
    @JoinColumn(name="comment_id",nullable = false)
    private Comments comments;

    @Column(name = "vote_type",nullable = false)
    private Integer voteType;


    public CommentVotes() {}

    public CommentVotes(String nickname, Integer commentId, Comments comments) {
        this.nickname = nickname;
        this.voteType = voteType;
        this.comments=comments;
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

    public Comments getComments(){
        return comments;
    }
    public void setComments(Comments comments){
        this.comments=comments;
    }
}
