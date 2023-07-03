package com.fs104.blogplatformapi.controller;

import com.fs104.blogplatformapi.model.BlogPost;
import com.fs104.blogplatformapi.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class BlogPostController {
    private final BlogPostService service;
    @Autowired
    public BlogPostController(BlogPostService service){
        this.service = service;
    }
    //Create
    @GetMapping("/create")
    public String createPage(Model model){
        model.addAttribute("post", new BlogPost());
        return "posts/create";
    }
    @PostMapping("/create")
    public String createPost(@ModelAttribute("post") BlogPost post){
        service.createPost(post);
        return "redirect:/posts/list";
    }
    //Read
    @GetMapping("/list")
    public String listPosts(Model model){
        model.addAttribute("postList", service.listPosts());
        return "posts/list";
    }
    @GetMapping("/list/{id}")
    public String readPost(@PathVariable("id") Long id, Model model){
        model.addAttribute("post", service.readPosts(id));
        return "posts/list";
    }
    //Update
    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable("id") Long id, Model model){
        model.addAttribute("post", service.readPosts(id));
        return "posts/update";
    }
    @PutMapping("/update/{id}")
    public String updatePost(@PathVariable("id") Long id, @ModelAttribute("post") BlogPost post){
        service.updatePost(id,post);
        return "redirect:/posts/list";
    }
    //Delete
    @DeleteMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") Long id){
        service.deletePost(id);
        return "redirect:/posts/list";
    }
}
