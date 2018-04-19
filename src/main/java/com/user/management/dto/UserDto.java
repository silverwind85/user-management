package com.user.management.dto;
import com.user.management.domain.GroupOfUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private LocalDate birthDate;
    private List<GroupOfUserDto> groupOfUserDtos=new ArrayList<>();
}
