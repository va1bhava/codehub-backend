package com.codehub.controllers;

import com.codehub.services.commentsVotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentVoteController {
    @Autowired
    private commentsVotesService commentsVoteService;

    @PostMapping("/commentvote/{commentID}/{nickname}/{voteType}")
    public String voteComment(@PathVariable Integer commentId,@PathVariable String nickname, Integer voteType){
       if(voteType!=1&&voteType!=-1){
          throw new RuntimeException("Invalid vote type ! ");
       }
        commentsVoteService.commentVote(commentId,nickname,voteType);
        return "Vote Succeeded";
    }
}
