package com.example.workshophelloservice.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HelloControlller {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/h1")
    public HelloResponse hi() {
        Optional<Message> optionalMessage = messageRepository.findById(1);
        String message = optionalMessage.get().getMessage();
        return new HelloResponse(message);
    }

}
