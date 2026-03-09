package com.codehub.services;
import com.codehub.Entity.Comments;
import com.codehub.Entity.Post;
import com.codehub.Exception.ResourceNotFound;
import com.codehub.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class commentsService {
    @Autowired
    private postRepository postRepo ;
    @Autowired
    private commentsRepository commentsRepo;

    public Comments createComment(Integer postId,Comments comments){
          Post post= postRepo.findById(postId).orElseThrow(()->new ResourceNotFound("Post Not found to Comment"));
          comments.setPost(post);
          return commentsRepo.save(comments);
    }
    public List<Comments>getCommentsByPost(Integer postId){
        return commentsRepo.findByPost_Id(postId);
    }
    public void deleteComments(Integer commentId){
        Comments comment=commentsRepo.findById(commentId).orElseThrow(()->new ResourceNotFound("Comment not found to delete"));
        commentsRepo.deleteById(commentId);
    }
}
