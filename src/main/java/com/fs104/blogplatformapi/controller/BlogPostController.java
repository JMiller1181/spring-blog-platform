package com.fs104.blogplatformapi.controller;

import com.fs104.blogplatformapi.model.BlogPost;
import com.fs104.blogplatformapi.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<BlogPost> createPost(@RequestBody BlogPost post){
        try {
            return new ResponseEntity<>(service.createPost(post), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //Read
    @GetMapping("/posts/list")
    public ResponseEntity<List<BlogPost>> listPosts(){
        try {
            List<BlogPost> list =  service.listPosts();
            if(list.isEmpty() || list.size() == 0){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/posts/list/{id}")
    public ResponseEntity<BlogPost> readPost(@PathVariable("id") Long id){
        return new ResponseEntity<>(service.readPosts(id), HttpStatus.OK);
    }
    //Update
    @PutMapping("/posts/update/{id}")
    public ResponseEntity<BlogPost> updatePost(@PathVariable("id") Long id, @RequestBody BlogPost newPost){
        try {
            service.updatePost(id,newPost);
            return new ResponseEntity<>(service.readPosts(id), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //Delete
    @DeleteMapping("/posts/delete/{id}")
    public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") Long id){
        try {
            service.deletePost(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
