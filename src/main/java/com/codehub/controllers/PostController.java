package com.codehub.controllers;
import com.codehub.Entity.Post;
import com.codehub.services.postService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class PostController {
    @Autowired
    private postService postservice;

    @PostMapping("/{sectionId}/posts")
    public Post createPost(@PathVariable Integer sectionId,
                           @RequestBody Post post) {
        return postservice.createpost(sectionId, post);
    }
    @GetMapping("/{sectionId}/getposts")
    public List<Post>fetchPostsbySection(@PathVariable Integer sectionId){
        return postservice.getPostsbySection(sectionId);
    }
    @PostMapping("/deletepost/{postId}")
    public void deletePost(@PathVariable Integer postId){
        postservice.deletePost(postId);

    }
}
