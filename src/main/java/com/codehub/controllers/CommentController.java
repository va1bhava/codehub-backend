package com.codehub.controllers;

import com.codehub.Entity.Comments;
import com.codehub.services.commentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class CommentController {
    @Autowired
    private commentsService commentsservice;

    @PostMapping("/{postId}/comments")
    public Comments createComments(@PathVariable Integer postId, @RequestBody Comments comments){
        return commentsservice.createComment(postId,comments);
    }
}
