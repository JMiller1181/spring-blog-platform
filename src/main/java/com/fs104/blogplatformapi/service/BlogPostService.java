package com.fs104.blogplatformapi.service;

import com.fs104.blogplatformapi.model.BlogPost;
import com.fs104.blogplatformapi.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlogPostService {
    private final BlogPostRepository repository;
    @Autowired
    public BlogPostService(BlogPostRepository repository){
        this.repository = repository;
    }
    public BlogPost createPost(BlogPost post){
        return repository.save(post);
    }
    public List<BlogPost> listPosts(){
        return repository.findAll();
    }
    public BlogPost readPosts(Long id){
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID"));
    }
    public void updatePost(Long id, BlogPost newPost){
        BlogPost existingPost = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID"));
        existingPost.setTitle(newPost.getTitle());
        existingPost.setContent(newPost.getContent());
        existingPost.setAuthor(newPost.getAuthor());
        repository.save(existingPost);
    }
    public void deletePost(Long id){
        repository.deleteById(id);
    }
}
