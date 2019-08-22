package com.example.workshophelloservice.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HelloService {

    private MessageRepository messageRepository;

    @Autowired
    public HelloService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public HelloResponse process() {
        Optional<Message> optionalMessage = messageRepository.findById(1);
        String message = optionalMessage.get().getData();
        return new HelloResponse(message);
    }

}
