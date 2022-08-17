package com.cg.school.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.cg.school.entity.User;
import com.cg.school.repository.UserRepository;
import com.cg.school.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.Assert;


import java.util.logging.Logger;

@WebMvcTest
public class UserControllerTest {

    @MockBean
    UserService userService;

    @MockBean
    UserRepository userRepository;

    @MockBean
    Logger logger;

    @Autowired
    private MockMvc mockMvc;

    private static ObjectMapper mapper = new ObjectMapper();

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testInsertUser() throws Exception {
        User user= new User();
        //"Bibhuti","Sahoo","10-01-2001","2nd","Bhusan","Remi"

        when(userRepository.save(user)).thenReturn(user);

        when(userService.saveUser(ArgumentMatchers.any())).thenReturn(user);

        String json = mapper.writeValueAsString(user);

        MvcResult requestResult = mockMvc.perform(post("/api/reg").contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON)).andReturn();

        String result = requestResult.getResponse().getContentAsString();

        Assert.notNull(result);

    }
}
