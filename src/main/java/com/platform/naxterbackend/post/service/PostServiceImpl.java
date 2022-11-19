package com.platform.naxterbackend.post.service;

import com.platform.naxterbackend.post.model.Post;
import com.platform.naxterbackend.post.model.Tag;
import com.platform.naxterbackend.post.model.UserPost;
import com.platform.naxterbackend.post.repository.PostRepository;
import com.platform.naxterbackend.post.repository.TagRepository;
import com.platform.naxterbackend.post.validator.SearchValidator;
import com.platform.naxterbackend.theme.model.Theme;
import com.platform.naxterbackend.theme.repository.ThemeRepository;
import com.platform.naxterbackend.user.model.User;
import com.platform.naxterbackend.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;
    @Autowired
    TagRepository tagRepository;
    @Autowired
    ThemeRepository themeRepository;
    @Autowired
    UserRepository userRepository;


    @Override
    public Post getPost(String id) {
        return this.postRepository.findById(id).get();
    }

    @Override
    public List<Post> getPosts() {
        return this.postRepository.findAll();
    }

    @Override
    public List<Post> searchPosts(String name, String theme, String user) {
        if(SearchValidator.validParam(name) && !SearchValidator.validParam(theme) && !SearchValidator.validParam(user)) {
            return this.postRepository.findAllByName(name);
        } else if(SearchValidator.validParam(name) && SearchValidator.validParam(theme) && !SearchValidator.validParam(user)) {
            return this.postRepository.findAllByNameAndTheme(name, theme);
        } else if(SearchValidator.validParam(name) && !SearchValidator.validParam(theme) && SearchValidator.validParam(user)) {
            return this.postRepository.findAllByNameAndUser(name, user);
        } else if(!SearchValidator.validParam(name) && SearchValidator.validParam(theme) && !SearchValidator.validParam(user)) {
            return this.postRepository.findAllByTheme(theme);
        } else if(!SearchValidator.validParam(name) && SearchValidator.validParam(theme) && SearchValidator.validParam(user)) {
            return this.postRepository.findAllByThemeAndUser(theme, user);
        } else {
            return this.postRepository.findAllByNameAndThemeAndUser(name, theme, user);
        }
    }

    @Override
    @Transactional(readOnly = false)
    public Post createPost(UserPost userPost) {
        Post post = new Post();
        post.setName(userPost.getName());
        post.setDescription(userPost.getDescription());

        User user = this.userRepository.findByNameIgnoreCase(userPost.getUser());
        post.setUser(user);

        Theme theme = this.themeRepository.findByNameIgnoreCase(userPost.getTheme());
        post.setTheme(theme);

        post.setDate(new Date());

        List<Tag> tags = new ArrayList<>();
        post.setTags(tags);

        return this.postRepository.save(post);
    }

    @Override
    @Transactional(readOnly = false)
    public Post editPost(String id, UserPost userPost) {
        Post post = this.postRepository.findById(id).get();
        post.setName(userPost.getName());
        post.setDescription(userPost.getDescription());

        return this.postRepository.save(post);
    }

    @Override
    @Transactional(readOnly = false)
    public String delete(String id) {
        Post post = this.postRepository.findById(id).get();

        for(Tag tag : post.getTags()) {
            this.tagRepository.delete(tag);
        }

        this.postRepository.delete(post);

        return id;
    }
}
