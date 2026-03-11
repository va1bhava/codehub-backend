package com.codehub.services;

import com.codehub.Entity.CommentVotes;
import com.codehub.Entity.Comments;
import com.codehub.Exception.ResourceNotFound;
import com.codehub.Repository.commentVoteRepository;
import com.codehub.Repository.commentsRepository;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class commentsVotesService {
    @Autowired
    private commentsRepository commentsRepo;

    @Autowired
    private commentVoteRepository commentVoteRepo;


    public void commentVote(Integer CommentId, String nickname , Integer voteType){
        Comments comment= commentsRepo.findById(CommentId).orElseThrow(()->new ResourceNotFound("Comments Not Found"));
        Optional<CommentVotes>existingVote= commentVoteRepo.findByComments_IdAndNickname(CommentId,nickname);
        if(existingVote.isEmpty()){
            CommentVotes newVote= new CommentVotes(nickname,CommentId,comment);
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
