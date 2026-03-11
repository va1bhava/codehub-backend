package com.codehub.services;

import com.codehub.Entity.CommentVotes;
import com.codehub.Entity.Comments;
import com.codehub.Exception.ResourceNotFound;
import com.codehub.Repository.commentVoteRepository;
import com.codehub.Repository.commentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class commentsVotesService {
    @Autowired
    private commentsRepository commentsRepo;

    @Autowired
    private commentVoteRepository commentVoteRepo;

    public void commentVote(int CommnentId, String nickname , int voteType){
        Comments comment= commentsRepo.findById(CommnentId).orElseThrow(()->new ResourceNotFound("Comments Not Found"));
        Optional<CommentVotes>existingVote= commentVoteRepo.findByCommentIdAndNickname(CommnentId,nickname);
        if(existingVote.isEmpty()){
            CommentVotes newVote= new CommentVotes(nickname,CommnentId,comment);
        }else{
            CommentVotes vote =existingVote.get();
            if(vote.getVoteType()==voteType){
                commentVoteRepo.delete(vote);
            }else{
                commentVoteRepo.save(vote);
            }
        }
    }
}
