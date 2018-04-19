package com.user.management.service;

import com.user.management.domain.GroupOfUser;
import com.user.management.dto.GroupOfUserDto;
import com.user.management.dto.UserDto;
import com.user.management.mapper.GroupOfUserMapper;
import com.user.management.repository.GroupOfUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupOfUserService {
    @Autowired
    private GroupOfUserRepository groupOfUserRepository;

    private GroupOfUserMapper groupOfUserMapper;

    public List<GroupOfUserDto> getGroupOfUsers() {
        return groupOfUserMapper.INSTANCE.groupOfUsersToGroupOfUserDtos(groupOfUserRepository.findAll());
    }

    public GroupOfUserDto saveGroupOfUser(GroupOfUserDto groupOfUserDto){
        return groupOfUserMapper.INSTANCE.groupOfUserToGroupOfUserDto(groupOfUserRepository.save(groupOfUserMapper.INSTANCE.groupOfUserDtoToGroupOfUser(groupOfUserDto)));
    }
    public void deleteGroupOfUser(Long id ){
        groupOfUserRepository.deleteById(id);
    }
}
