package com.codehub.controllers;

import com.codehub.Entity.Comments;
import com.codehub.services.commentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CommentController {
    @Autowired
    private commentsService commentsservice;

    @PostMapping("/{postId}/comments")
    public Comments createComments(@PathVariable Integer postId, @RequestBody Comments comments){
        return commentsservice.createComment(postId,comments);
    }
    @GetMapping("/{postId}/getcomments")
    public List<Comments> getAllComments(@PathVariable Integer postId){
        return commentsservice.getCommentsByPost(postId);
    }
    @PostMapping("/deletecomment/{commentId}")
    public void deleteComment(@PathVariable Integer commentId){
        commentsservice.deleteComments(commentId);
    }
}
