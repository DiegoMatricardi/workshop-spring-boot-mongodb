package org.example.workshopmongo.resources;

import org.example.workshopmongo.DTO.UserDTO;
import org.example.workshopmongo.domain.Post;
import org.example.workshopmongo.domain.User;
import org.example.workshopmongo.resources.util.URL;
import org.example.workshopmongo.services.PostService;
import org.example.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService postService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String title) {
        title = URL.decodeParam(title);
        List<Post> list = postService.findByTitle(title);
        return ResponseEntity.ok().body(list);
    }
}
