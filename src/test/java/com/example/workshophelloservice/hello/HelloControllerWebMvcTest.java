package com.example.workshophelloservice.hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerWebMvcTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MessageRepository messageRepository;

    @Before
    public void initData() {
        Message message = new Message();
        message.setId(1);
        message.setData("Hello World");
        given(this.messageRepository.findById(1))
                .willReturn(Optional.of(message));
    }

    @Test
    public void success_with_hi() throws Exception {
        MvcResult mvcResult = this.mvc.perform(get("/hi").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        String json = mvcResult.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        HelloResponse response = mapper.readValue(json, HelloResponse.class);

        assertEquals("Hello World", response.getMessage());
    }
}