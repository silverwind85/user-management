package com.user.management.controller;

import com.user.management.domain.User;
import com.user.management.dto.GroupOfUserDto;
import com.user.management.dto.UserDto;
import com.user.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "users")
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(method = RequestMethod.POST, value = "users", consumes = APPLICATION_JSON_VALUE)
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "users")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "users/")
    public void deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);

    }
    /*@RequestMapping(method = RequestMethod.POST, value = "users/{Id}addGroup")
    public List<GroupOfUserDto> addUser(@PathVariable Long id ){

    }*/


}
