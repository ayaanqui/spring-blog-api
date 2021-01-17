package com.github.ayaanqui.springblogapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.github.ayaanqui.springblogapi.models.Post;
import com.github.ayaanqui.springblogapi.serializers.PostSerailizer.PostInfo;
import com.github.ayaanqui.springblogapi.repositories.PostRepository;

@Controller
@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("")
    public @ResponseBody ArrayList<PostInfo> getPosts() {
        Iterable<Post> posts = postRepository.findAll();
        ArrayList<PostInfo> postsInfo = new ArrayList<>();
        for (Post p : posts) {
            postsInfo.add(new PostInfo(p));
        }
        return postsInfo;
    }

    @PostMapping("")
    public @ResponseBody Object createPost(@RequestParam(required = true) String title,
            @RequestParam(required = true) String content, @RequestParam(required = true) String description,
            @RequestParam(required = true) String published, @RequestParam(required = false) String image) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setDescription(description);
        post.setImage(image);
        post.setPublished(Timestamp.valueOf(published));

        postRepository.save(post);
        return new Object() {
            public String message = "Post created";
        };
    }
}
