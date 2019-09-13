package com.example.workshophelloservice.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HelloControlller {

    private static final Logger log = LoggerFactory.getLogger(HelloControlller.class);

    @Autowired
    private HelloService helloService;

    @GetMapping("/hi")
    public HelloResponse hi() {
        log.info("Start to say hi");
        return helloService.process();
    }

}
