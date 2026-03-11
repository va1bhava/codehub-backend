package com.codehub.services;

import com.codehub.Entity.Post;
import com.codehub.Entity.PostVotes;
import com.codehub.Exception.ResourceNotFound;
import com.codehub.Repository.postRepository;
import com.codehub.Repository.postVotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.Optional;

@Service
public class postVoteService {
    @Autowired
    private postRepository postRepo;

    @Autowired
    private postVotesRepository postVoteRepo;

    public void votePost(int postId ,String nickname , int voteType){
        Post post= postRepo.findById(postId).orElseThrow(()->new ResourceNotFound("Post Not Found"));
        Optional<PostVotes>existingVote=postVoteRepo. findByPost_IdAndNickname(postId,nickname);
        if(existingVote.isEmpty()){
            PostVotes postVote = new PostVotes(nickname,postId,post);
        }else{
            PostVotes vote= existingVote.get();
            if(vote.getVoteType()==voteType){
                postVoteRepo.delete(vote);
            }else{
                postVoteRepo.save(vote);
            }
        }
    }
}
