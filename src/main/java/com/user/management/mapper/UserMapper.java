package com.user.management.mapper;
import com.user.management.domain.User;
import com.user.management.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {


    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    List<UserDto> usersToUserDtos(List<User> users);
    @Mapping(target = "groupOfUserDtos", source = "groupOfUsers")
    UserDto userToUserDto(User user);
    List<User> userDtosToUsers(List<UserDto> userdtos);
    @Mapping(target = "groupOfUsers", source="groupOfUserDtos")
    User userDtoToUser(UserDto userDto);

}

