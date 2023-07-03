package com.fs104.blogplatformapi.controller;

import com.fs104.blogplatformapi.model.BlogPost;
import com.fs104.blogplatformapi.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogPostController {
    private final BlogPostService service;
    @Autowired
    public BlogPostController(BlogPostService service){
        this.service = service;
    }
    //Create
    @PostMapping("/posts/create")
    public void createPost(@RequestBody BlogPost post){
        service.createPost(post);
    }
    //Read
    @GetMapping("/posts/list")
    public List<BlogPost> listPosts(){
        return service.listPosts();
    }
    @GetMapping("/posts/list/{id}")
    public BlogPost readPost(@PathVariable("id") Long id){
        return service.readPosts(id);
    }
    //Update
    @PutMapping("/posts/update/{id}")
    public BlogPost updatePost(@PathVariable("id") Long id, @RequestBody BlogPost newPost){
        service.updatePost(id,newPost);
        return service.readPosts(id);
    }
    //Delete
    @DeleteMapping("/posts/delete/{id}")
    public void deletePost(@PathVariable("id") Long id){
        service.deletePost(id);
    }
}
