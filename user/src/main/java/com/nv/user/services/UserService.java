package com.nv.user.services;

import com.nv.user.dtos.CreateUserDto;
import com.nv.user.models.User;
import com.nv.user.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(CreateUserDto createUserDto) {
        User user = modelMapper.map(createUserDto, User.class);
        return userRepository.save(user);
    }
}
