package com.manza.rest.webservices.restfulwebservices.post;

import com.manza.rest.webservices.restfulwebservices.user.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostResource {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users/{userId}/posts")
    public List<Post> retrievelAllPostsByUser(@PathVariable int userId) {
        return userDaoService.findAllPostsByUser(userId);
    }

    @PostMapping("/users/{userId}/posts")
    public Post saveNewPostByUser(@PathVariable int userId, @RequestBody Post post) {
        return userDaoService.savePost(userId, post);
    }

    @GetMapping("users/{userId}/posts/{postId}")
    public Post retrievePost(@PathVariable int userId, @PathVariable int postId) {
        return userDaoService.retrievePost(userId, postId);
    }

}
