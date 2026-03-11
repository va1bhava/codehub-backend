package com.codehub.controllers;

import com.codehub.services.postVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostVotesController {
    @Autowired
    private postVoteService postvoteservice;
    @PostMapping("/postvote/{postId}/{nickname}/{voteType}")
    public String votePost(@PathVariable Integer postId, @PathVariable String nickname ,
                           @PathVariable Integer voteType){
        if(voteType!=1&&voteType!=-1){
            throw new RuntimeException("Invalid vote type ! ");
        }
        postvoteservice.votePost(postId,nickname,voteType);

        return "Vote Succeeded";
    }
}
