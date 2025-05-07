package org.example.workshopmongo.services;

import org.example.workshopmongo.DTO.UserDTO;
import org.example.workshopmongo.domain.Post;
import org.example.workshopmongo.domain.User;
import org.example.workshopmongo.repository.PostRepository;
import org.example.workshopmongo.repository.UserRepository;
import org.example.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String title) {
        return postRepository.findByTitle(title);
    }
}
