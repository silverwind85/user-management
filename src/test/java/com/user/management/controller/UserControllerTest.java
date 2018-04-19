package com.user.management.controller;

import com.google.gson.Gson;
import com.user.management.dto.GroupOfUserDto;
import com.user.management.dto.UserDto;
import com.user.management.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {


    private UserDto userDto;

    private GroupOfUserDto groupOfUserDto;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;


    @Before
    public void before() {
        groupOfUserDto = new GroupOfUserDto();
        groupOfUserDto.setId(1L);
        groupOfUserDto.setName("test_name");
        userDto = new UserDto();
        userDto.setId(1L);
        userDto.setFirstName("test_firstName");
        userDto.setLastName("test_lastName");
        userDto.setPassword("test_password");
       /* userDto.setBirthday(LocalDate.now());*/
        userDto.getGroupOfUserDtos().add(groupOfUserDto);

    }

    @Test
    public void testGetUsers() throws Exception {
        //Given
        when(userService.getUsers()).thenReturn(new ArrayList<>());
        //When & Then
        mockMvc.perform(get("/v1/users").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void testDeleteUser() throws Exception {
        //Given
        mockMvc.perform(delete("/v1/users/").param("id", "1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void createUser() throws Exception {
        //Given
        Gson gson = new Gson();
        String jsonContent = gson.toJson(userDto);
        when(userService.saveUser(any(UserDto.class))).thenReturn(userDto);
        //When && Then
        mockMvc.perform(post("/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.firstName", is("test_firstName")))
                .andExpect(jsonPath("$.lastName", is("test_lastName")))
                .andExpect(jsonPath("$.password", is("test_password")));
                /*.andExpect(jsonPath("$.date", is(2018 - 1 - 1)));*/
    }

    @Test
    public void updateUser() throws Exception {
        //Given
        Gson gson = new Gson();
        String jsonContent = gson.toJson(userDto);
        when(userService.saveUser(any(UserDto.class))).thenReturn(userDto);
        //When && Then
        mockMvc.perform(post("/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.firstName", is("test_firstName")))
                .andExpect(jsonPath("$.lastName", is("test_lastName")))
                .andExpect(jsonPath("$.password", is("test_password")));
                /*.andExpect(jsonPath("$.date", is(2018 - 1 - 1)));*/
    }
}