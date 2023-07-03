package com.fs104.blogplatformapi.repository;

import com.fs104.blogplatformapi.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost,Long> {
}
