package com.example.workshophelloservice.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HelloController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/hi")
    public HelloResponse hi() {
        Optional<Message> optionalMessage = messageRepository.findById(1);
        String message = optionalMessage.get().getData();
        return new HelloResponse(message);
    }

}
