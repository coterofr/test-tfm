package com.platform.naxterbackend.post.repository;

import com.platform.naxterbackend.post.model.Post;
import com.platform.naxterbackend.theme.model.Theme;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'name' : { '$regex' : ?0 , $options: 'i'}}")
    List<Post> findAllByName(String name);

    @Query("{ 'name' : { '$regex' : ?0 , $options: 'i'}, 'theme.$id' : { '$regex' : ?1 , $options: 'i'} }")
    List<Post> findAllByNameAndTheme(String name, String theme);

    @Query("{ 'name' : { '$regex' : ?0 , $options: 'i'}, 'user.$id' : { '$regex' : ?1 , $options: 'i'} }")
    List<Post> findAllByNameAndUser(String name, String user);

    @Query("{ 'theme.$id' : { '$regex' : ?0 , $options: 'i'}}")
    List<Post> findAllByTheme(String theme);

    @Query("{ 'theme.$id' : { '$regex' : ?0 , $options: 'i'}, 'user.$id' : { '$regex' : ?1 , $options: 'i'} }")
    List<Post> findAllByThemeAndUser(String theme, String user);

    @Query("{ 'name' : { '$regex' : ?0 , $options: 'i'}, 'theme.$id' : { '$regex' : ?1 , $options: 'i'}, 'user.$id' : { '$regex' : ?2 , $options: 'i'} }")
    List<Post> findAllByNameAndThemeAndUser(String name, String theme, String user);

    Post save(Post post);
}
