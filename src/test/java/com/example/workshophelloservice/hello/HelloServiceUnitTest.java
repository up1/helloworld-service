package com.example.workshophelloservice.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class HelloServiceUnitTest {

    @Mock
    private MessageRepository messageRepository;

    private HelloService helloService;

    @Test
    public void process() {
        Message message = new Message();
        message.setData("Hello World");
        given(this.messageRepository.findById(1))
                .willReturn(Optional.of(message));

        helloService = new HelloService(messageRepository);
        HelloResponse response = helloService.process();
        assertEquals("Hello World", response.getMessage());
    }
}