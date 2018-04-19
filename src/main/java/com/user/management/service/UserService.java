package com.user.management.service;

import com.user.management.domain.User;
import com.user.management.dto.UserDto;
import com.user.management.mapper.UserMapper;
import com.user.management.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRespository userRespository;

    private UserMapper userMapper;

    public List<UserDto> getUsers() {
        return userMapper.INSTANCE.usersToUserDtos(userRespository.findAll());
    }

    public UserDto saveUser(UserDto userDto) {
        return userMapper.INSTANCE.userToUserDto(userRespository.save(userMapper.INSTANCE.userDtoToUser(userDto)));
    }
    public void deleteUser(Long id) {
        userRespository.deleteById(id);
    }

}
