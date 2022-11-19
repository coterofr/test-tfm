package com.platform.naxterbackend.post.model;

import com.platform.naxterbackend.comment.model.Comment;
import com.platform.naxterbackend.theme.model.Theme;
import com.platform.naxterbackend.user.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Document("post")
public class Post {

    @Id
    private String id;

    @NotBlank
    @Size(min = 5, max = 25)
    private String name;

    @Size(min = 5, max = 500)
    private String description;

    private Boolean subscriber;

    private String multimedia;

    @NotNull
    @DBRef
    private Theme theme;

    @NotNull
    @DBRef
    private User user;

    @NotNull
    private Date date;

    @DBRef
    private List<Tag> tags;

    @ReadOnlyProperty
    @DocumentReference(lookup="{'post':?#{#self._id}}")
    private List<Comment> comments;


    public Post() { }

    public Post(String name, String description, Boolean subscriber, String multimedia, User user, Theme theme, Date date, List<Tag> tags) {
        this.name = name;
        this.description = description;
        this.subscriber = subscriber;
        this.multimedia = multimedia;
        this.user = user;
        this.theme = theme;
        this.date = date;
        this.tags = tags;
        this.comments = new ArrayList<>();
    }
}
