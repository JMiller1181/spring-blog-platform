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
    public void createPost(String title, String content, String author){
        BlogPost post = new BlogPost();
        post.setAuthor(author);
        post.setContent(content);
        post.setTitle(title);
        repository.save(post);
    }
    public List<BlogPost> listPosts(){
        return repository.findAll();
    }
    public BlogPost readPosts(Long id){
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID"));
    }
    public void updatePost(BlogPost existingPost, String title, String content, String author){
        existingPost.setTitle(title);
        existingPost.setContent(content);
        existingPost.setAuthor(author);
        repository.save(existingPost);
    }
    public void deletePost(Long id){
        repository.deleteById(id);
    }
}
