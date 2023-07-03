package com.fs104.blogplatformapi;

import com.fs104.blogplatformapi.model.BlogPost;
import com.fs104.blogplatformapi.repository.BlogPostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogPlatformApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogPlatformApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(BlogPostRepository repository){
        return args -> {
            createDummyPosts(repository);
        };
    }
    private void createDummyPosts(BlogPostRepository repository){
        repository.save(new BlogPost("First", "Body", "Jacob"));
        repository.save(new BlogPost("Second", "Content", "Jacob"));
    }
}
