package com.udemy.userinformation.mapper;

import com.udemy.userinformation.dto.UserDTO;
import com.udemy.userinformation.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO mapUserToUserDTO(User user);
    User mapUserDTOToUser(UserDTO userDTO);
}
