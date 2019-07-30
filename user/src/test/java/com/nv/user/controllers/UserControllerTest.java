package com.nv.user.controllers;

import com.nv.user.dtos.CreateUserDto;
import com.nv.user.models.User;
import com.nv.user.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {
    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getUsers_shouldReturnUsers() throws Exception {
        when(userService.getAllUsers()).thenReturn(Collections.singletonList(User.builder().id(10).build()));
        mockMvc.perform(get("/users")).andExpect(status().isOk()).andReturn();

        verify(userService).getAllUsers();
    }

    @Test
    public void createUser_shouldCreateUsers() throws Exception {
        mockMvc.perform(post("/users")
                .contentType("application/json")
                .content("{\"firstName\": \"somename\"}".getBytes()))
                .andExpect(status().isOk()).andReturn();

        verify(userService).createUser(any(CreateUserDto.class));
    }

}
