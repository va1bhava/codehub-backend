package com.codehub.services;

import com.codehub.Entity.Post;
import com.codehub.Entity.Section;
import com.codehub.Exception.ResourceNotFound;
import com.codehub.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class postService {
    private postRepository postRepo;
    private sectionRepository sectionRepo;
    @Autowired
    public postService(postRepository postRepo,sectionRepository sectionRepo){
        this.postRepo=postRepo;
        this.sectionRepo=sectionRepo;
    }
    public Post createpost(int sectionId, Post post){
        Section section = sectionRepo.findById(sectionId)
                .orElseThrow(() -> new ResourceNotFound("Section not found"));
        post.setSection(section);
        return postRepo.save(post);
    }
    public List<Post> getPostsbySection(int sectionId){
        return postRepo.findBySection_Id(sectionId);
    }
    public Post getPost(Integer postId){
        return postRepo.findById(postId).orElseThrow(()->new ResourceNotFound("Post Not Found !! "));
    }
    public void deletePost(Integer postId){
        Post post= postRepo.findById(postId).orElseThrow(()->new ResourceNotFound("Post not found to delete"));
        postRepo.deleteById(postId);
    }
}
