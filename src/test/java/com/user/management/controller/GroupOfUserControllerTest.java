package com.user.management.controller;

import com.google.gson.Gson;
import com.user.management.dto.GroupOfUserDto;
import com.user.management.dto.UserDto;
import com.user.management.service.GroupOfUserService;
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

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GroupOfUserController.class)
public class GroupOfUserControllerTest {

    private GroupOfUserDto groupOfUserDto;
    private UserDto userDto;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GroupOfUserService groupOfUserService;

    @Before
    public void before() {
        userDto = new UserDto();
        userDto.setId(1L);
        userDto.setFirstName("test_firstName");
        userDto.setLastName("test_lastName");
        userDto.setPassword("test_password");
       /* userDto.setBirthday(LocalDate.now());*/
        groupOfUserDto = new GroupOfUserDto();
        groupOfUserDto.setId(1L);
        groupOfUserDto.setName("test_name");
        groupOfUserDto.getUserDtos().add(userDto);
    }

    @Test
    public void getGroupOfUsers() throws Exception {
        //Given
        when(groupOfUserService.getGroupOfUsers()).thenReturn(new ArrayList<>());
        //When & Then
        mockMvc.perform(get("/v1/groups").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void testDeleteUser() throws Exception {
        //Given
        mockMvc.perform(delete("/v1/groups/").param("id", "1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void createGroupOfUser() throws Exception {
        //Given
        Gson gson = new Gson();
        String jsonContent = gson.toJson(groupOfUserDto);
        when(groupOfUserService.saveGroupOfUser(any(GroupOfUserDto.class))).thenReturn(groupOfUserDto);
        //When && Then
        mockMvc.perform(post("/v1/groups")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("test_name")))
                .andExpect(jsonPath("$.userDtos", hasSize(1)))
                .andExpect(jsonPath("$.userDtos[*].id", containsInAnyOrder(1)))
                .andExpect(jsonPath("$.userDtos[*].firstName", containsInAnyOrder("test_firstName")))
                .andExpect(jsonPath("$.userDtos[*].lastName", containsInAnyOrder("test_lastName")));
                /*.andExpect(jsonPath("$.date", is(2018 - 1 - 1)));*/
    }

    @Test
    public void UpdateGroupOfUser() throws Exception {
        //Given
        Gson gson = new Gson();
        String jsonContent = gson.toJson(groupOfUserDto);
        when(groupOfUserService.saveGroupOfUser(any(GroupOfUserDto.class))).thenReturn(groupOfUserDto);
        //When && Then
        mockMvc.perform(put("/v1/groups")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("test_name")))
                .andExpect(jsonPath("$.userDtos", hasSize(1)))
                .andExpect(jsonPath("$.userDtos[*].id", containsInAnyOrder(1)))
                .andExpect(jsonPath("$.userDtos[*].firstName", containsInAnyOrder("test_firstName")))
                .andExpect(jsonPath("$.userDtos[*].lastName", containsInAnyOrder("test_lastName")));
                /*.andExpect(jsonPath("$.date", is(2018 - 1 - 1)));*/
    }

}