package com.codehub.services;
import com.codehub.Entity.Comments;
import com.codehub.Entity.Post;
import com.codehub.Exception.ResourceNotFound;
import com.codehub.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
public class commentsService {
    @Autowired
    private postRepository postRepo ;
    @Autowired
    private commentsRepository commentsRepo;

    public Comments createComment(int postId,Comments comments){
          Post post= postRepo.findById(postId).orElseThrow(()->new ResourceNotFound("Post Not found to Comment"));
          comments.setPost(post);
          return commentsRepo.save(comments);
    }
    public List<Comments>getCommentsByPost(int postId){
        return commentsRepo.findByPost_Id(postId);
    }
}
