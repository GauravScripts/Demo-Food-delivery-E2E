package com.udemy.userinformation.service;

import com.udemy.userinformation.dto.UserDTO;
import com.udemy.userinformation.entity.User;
import com.udemy.userinformation.mapper.UserMapper;
import com.udemy.userinformation.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;


    public UserDTO addUser(UserDTO userDTO){
        return UserMapper.INSTANCE.mapUserToUserDTO(userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO)));
    }

    public ResponseEntity<UserDTO> fetchUserById(Integer id){
        Optional<User> fetchUser = userRepo.findById(id);
        return fetchUser.map(user -> ResponseEntity.ok(UserMapper.INSTANCE.mapUserToUserDTO(user))).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
