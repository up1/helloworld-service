package com.example.workshophelloservice.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/hi")
    public HelloResponse hi() {
        log.info("Start to say hi");

        Optional<Message> optionalMessage = messageRepository.findById(1);
        String message = optionalMessage.get().getData();

        log.info("Say hi with message : {}" , message);

        call2();

        return new HelloResponse(message);
    }

    private void call1() {
        call2();
    }

    private void call2() {

    }

}
