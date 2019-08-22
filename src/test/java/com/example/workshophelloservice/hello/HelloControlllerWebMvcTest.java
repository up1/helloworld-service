package com.example.workshophelloservice.hello;

import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloControlller.class)
public class HelloControlllerWebMvcTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private HelloService helloService;

    @Test
    public void hi() throws Exception {
        HelloResponse helloResponse = new HelloResponse();
        helloResponse.setMessage("Hello World 2");

        given(this.helloService.process())
                .willReturn(helloResponse);

        MvcResult result = this.mvc.perform(get("/hi").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String json = result.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        HelloResponse response = mapper.readValue(json, HelloResponse.class);

        // Assert
        assertEquals("Hello World 2", response.getMessage());
    }
}