package com.user.management.controller;



import com.user.management.domain.GroupOfUser;
import com.user.management.dto.GroupOfUserDto;
import com.user.management.dto.UserDto;
import com.user.management.service.GroupOfUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("v1/")
public class GroupOfUserController {
    @Autowired
    private GroupOfUserService groupOfUserService;

    @RequestMapping (method= RequestMethod.GET, value = "groups")
    public List<GroupOfUserDto> getGroupofUsers() {
        return groupOfUserService.getGroupOfUsers();
    }

    @RequestMapping(method = RequestMethod.POST, value = "groups", consumes = APPLICATION_JSON_VALUE)
    public GroupOfUserDto createGroupofUser(@RequestBody GroupOfUserDto groupOfUserDto) {
        return groupOfUserService.saveGroupOfUser(groupOfUserDto);

    }
    @RequestMapping(method = RequestMethod.PUT, value = "groups")
    public GroupOfUserDto UpdateGroupofUser(@RequestBody GroupOfUserDto groupOfUserDto) {
        return groupOfUserService.saveGroupOfUser(groupOfUserDto);

    }
    @RequestMapping(method = RequestMethod.DELETE, value = "groups/")
    public void deleteGroupofUsers(@RequestParam Long id){
        groupOfUserService.deleteGroupOfUser(id);

    }


}
