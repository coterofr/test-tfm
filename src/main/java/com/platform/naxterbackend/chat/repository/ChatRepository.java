package com.platform.naxterbackend.chat.repository;

import com.platform.naxterbackend.chat.model.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends MongoRepository<Chat, String> {
}
