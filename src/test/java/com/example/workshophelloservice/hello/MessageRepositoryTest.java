package com.example.workshophelloservice.hello;

import com.example.workshophelloservice.IntegrationTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@Category(IntegrationTest.class)
@RunWith(SpringRunner.class)
@DataJpaTest
public class MessageRepositoryTest {

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
    public void found_message_with_get_data_by_id() {
        Optional<Message> optionalMessage = messageRepository.findById(1);
        String message = optionalMessage.get().getData();
        assertEquals("Hello World", message);
    }

}