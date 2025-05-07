package org.example.workshopmongo.repository;

import org.example.workshopmongo.domain.Post;
import org.example.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> seachByTitle(String text);


    List<Post> findByTitle(String text);
}
