package com.platform.naxterbackend.chat.model;

import com.platform.naxterbackend.user.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Document("chat")
public class Chat {

    @Id
    private String id;

    @NotBlank
    @Size(min = 1, max = 100)
    private String message;

    @NotNull
    @DBRef
    private User emmiter;

    @NotNull
    @DBRef
    private User receiver;


    public Chat() { }

    public Chat(String message, User emmiter, User receiver) {
        this.message = message;
        this.emmiter = emmiter;
        this.receiver = receiver;
    }
}
