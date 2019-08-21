package com.example.workshophelloservice.hello;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.springframework.boot.test.context.SpringBootTest.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloControlllerSpringBootTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MessageRepository messageRepository;

    @Before
    public void initData() {
        Message message = new Message();
        message.setId(1);
        message.setData("Hello World");
        messageRepository.save(message);
    }

    @Test
    public void success_with_hi() {
        HelloResponse response = this.restTemplate.getForObject("/hi", HelloResponse.class);
        assertEquals("Hello World", response.getMessage());
    }
}