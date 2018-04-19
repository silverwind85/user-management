package com.user.management.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class GroupOfUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="groupOfUser_id" )
    private Long Id;
    @NotNull
    private String name;
    @ManyToMany(mappedBy = "groupOfUsers")
    private List<User> users = new ArrayList<>();
}
