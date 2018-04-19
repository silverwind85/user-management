package com.user.management.mapper;

import com.user.management.domain.GroupOfUser;
import com.user.management.dto.GroupOfUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GroupOfUserMapper {

    GroupOfUserMapper INSTANCE = Mappers.getMapper(GroupOfUserMapper.class);


    List<GroupOfUserDto> groupOfUsersToGroupOfUserDtos(List<GroupOfUser> groupOfUsers);
    @Mapping(target = "userDtos", source = "users")
    GroupOfUserDto groupOfUserToGroupOfUserDto(GroupOfUser groupOfUser);
    List<GroupOfUser> groupOfUserDtosTogroupOfUsers(List<GroupOfUserDto> GroupOfUserDtos);
    @Mapping(target = "users", source="userDtos")
    GroupOfUser groupOfUserDtoToGroupOfUser(GroupOfUserDto groupOfUserDto);

}
