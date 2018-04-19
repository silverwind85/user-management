package com.user.management.dto;
import com.user.management.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GroupOfUserDto {
    private Long Id;
    private String name;
    private List<UserDto> userDtos = new ArrayList<>();
}