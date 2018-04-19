package com.user.management.repository;

import com.user.management.domain.GroupOfUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupOfUserRepository extends CrudRepository<GroupOfUser,Long>{
    List<GroupOfUser> findAll();
    GroupOfUser save(GroupOfUser groupOfUser);
    void deleteById(Long id);
}
