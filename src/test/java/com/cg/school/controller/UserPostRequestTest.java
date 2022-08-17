package com.cg.school.controller;

import com.cg.school.dto.Student;
import com.cg.school.repository.UserRepository;
import com.cg.school.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(value = UserController.class)
public class UserPostRequestTest {

    @MockBean
    private UserRepository repository;

    @MockBean
    private UserService service;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Student student;

    @Test
    public void testAddUser() throws Exception {
        Student student = new Student();
        ObjectMapper mapper= new ObjectMapper();
        String userJson= mapper.writeValueAsString(student);

        MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.post("/api/reg")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson);

        ResultActions perform= mockMvc.perform(reqBuilder);
        MvcResult mvcResult= perform.andReturn();
        MockHttpServletResponse response= mvcResult.getResponse();
        int status = response.getStatus();
        assertEquals(400,status);
    }

}
