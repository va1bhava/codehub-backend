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
    private postVotesRepository postVoteRepo;
    @Autowired
    public postService(postRepository postRepo,sectionRepository sectionRepo,postVotesRepository postVoteRepo){
        this.postRepo=postRepo;
        this.sectionRepo=sectionRepo;
        this.postVoteRepo=postVoteRepo;
    }
    public Post createpost(int sectionId, Post post){
        Section section = sectionRepo.findById(sectionId)
                .orElseThrow(() -> new ResourceNotFound("Section not found"));
        post.setSection(section);
        return postRepo.save(post);
    }
    public List<Post> getPostsbySection(Integer sectionId){
        List<Post>posts =postRepo.findBySection_Id(sectionId);
        for(Post post: posts){
            Integer votes= postVoteRepo.getPostVoteScore(post.getId());
            post.setVotes(votes);
        }
        return posts;
    }
    public Post getPost(Integer postId){
        return postRepo.findById(postId).orElseThrow(()->new ResourceNotFound("Post Not Found !! "));
    }
    public void deletePost(Integer postId){
        Post post= postRepo.findById(postId).orElseThrow(()->new ResourceNotFound("Post not found to delete"));
        postRepo.deleteById(postId);
    }
}
