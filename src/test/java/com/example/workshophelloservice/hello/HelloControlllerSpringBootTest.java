package com.example.workshophelloservice.hello;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloControlllerSpringBootTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MessageRepository messageRepository;

    @Before
    public void initialData() {
        Message message = new Message();
        message.setId(1);
        message.setData("Hello World 2");
        messageRepository.save(message);
    }

    @After
    public void delete() {
        messageRepository.deleteById(1);
    }

    @Test
    public void success_with_hi() {
        // Act
        HelloResponse response
                = restTemplate.getForObject("/hi", HelloResponse.class);
        // Assert
        assertEquals("Hello World 2", response.getMessage());
    }
}