package com.example.workshophelloservice.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HelloControlller {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hi")
    public HelloResponse hi() {
        return helloService.process();
    }

}
