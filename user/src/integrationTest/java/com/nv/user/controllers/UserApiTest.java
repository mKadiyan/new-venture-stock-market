package com.nv.user.controllers;

import com.nv.user.models.User;
import com.nv.user.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserApiTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    protected TestRestTemplate restTemplate;

    @Before
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void shouldCreateAUser() {
        User user = User
                .builder()
                .id(10)
                .username("somename")
                .build();

        restTemplate.postForEntity("/users", user, User.class);

        List<User> allUsers = userRepository.findAll();
        assertThat(allUsers, hasSize(1));
    }

    @Test
    public void shouldFetchAllUsers() {
        User user = User
                .builder()
                .username("my-username")
                .firstName("nv-user")
                .build();
        userRepository.save(user);
        User[] actualUsers = restTemplate.getForEntity("/users", User[].class).getBody();
        assertThat(actualUsers, arrayWithSize(1));
        assertThat(actualUsers, arrayContaining(user));
    }
}
