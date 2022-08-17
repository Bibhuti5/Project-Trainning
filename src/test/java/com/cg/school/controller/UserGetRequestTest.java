package com.cg.school.controller;


import com.cg.school.repository.UserRepository;
import com.cg.school.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.jupiter.api.Assertions.assertEquals;


@WebMvcTest(value = UserController.class)
public class UserGetRequestTest {

    @MockBean
    private UserRepository repository;

    @MockBean
    private UserService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetUser() throws Exception {
//      when(service.getAllUsers()).thenReturn("Hi This is working");
      MockHttpServletRequestBuilder reqBuilder= MockMvcRequestBuilders.get("/api/reg");

      ResultActions perform= mockMvc.perform(reqBuilder);
      MvcResult mvcResult= perform.andReturn();
      MockHttpServletResponse response= mvcResult.getResponse();
      int status = response.getStatus();
      assertEquals(200,status);
    }



}

