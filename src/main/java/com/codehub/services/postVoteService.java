package com.codehub.services;

import com.codehub.Entity.Post;
import com.codehub.Entity.PostVotes;
import com.codehub.Exception.ResourceNotFound;
import com.codehub.Repository.postRepository;
import com.codehub.Repository.postVotesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.Optional;

@Service
@Transactional
public class postVoteService {

    @Autowired
    private postRepository postRepo;

    @Autowired
    private postVotesRepository postVoteRepo;


    public void votePost(Integer postId ,String nickname , Integer voteType){

        Post post= postRepo.findById(postId).orElseThrow(()->new ResourceNotFound("Post Not Found"));
        Optional<PostVotes>existingVote=postVoteRepo. findByPost_IdAndNickname(postId,nickname);
        if(existingVote.isEmpty()){

            PostVotes postVote = new PostVotes();

            postVote.setPost(post);
            postVote.setNickname(nickname);
            postVote.setVoteType(voteType);
            postVoteRepo.save(postVote);
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
