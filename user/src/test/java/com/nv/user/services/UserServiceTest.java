package com.nv.user.services;

import com.nv.user.dtos.CreateUserDto;
import com.nv.user.models.User;
import com.nv.user.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private UserService userService;

    @Test
    public void getAllUsers_shouldReturnAllUsers() {
        User user = User.builder().id(10).build();
        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));

        List<User> allUsers = userService.getAllUsers();

        assertThat(allUsers, hasSize(1));
        assertThat(allUsers, hasItem(user));
    }

    @Test
    public void createUsers_shouldReturnCreatedUsers() {
        CreateUserDto createUserDto = new CreateUserDto();
        createUserDto.setFirstName("some username");
        User user = User.builder().id(10).firstName("some username").build();
        User userToBeSaved = User.builder().firstName("some username").build();
        when(modelMapper.map(createUserDto, User.class)).thenReturn(userToBeSaved);
        when(userRepository.save(userToBeSaved)).thenReturn(user);

        User savedUser = userService.createUser(createUserDto);

        assertThat(savedUser, samePropertyValuesAs(user));
    }
}
