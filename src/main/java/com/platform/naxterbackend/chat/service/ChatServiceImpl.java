package com.platform.naxterbackend.chat.service;

import com.platform.naxterbackend.chat.model.Chat;
import com.platform.naxterbackend.chat.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ChatServiceImpl implements ChatService {

    @Autowired
    ChatRepository chatRepository;

    public List<Chat> getChats() {
        return this.chatRepository.findAll();
    }
}
