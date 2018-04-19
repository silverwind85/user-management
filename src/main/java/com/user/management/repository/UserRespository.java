package com.user.management.repository;

import com.user.management.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRespository extends CrudRepository<User, Long>{
    List<User> findAll();
    User save(User user);
    void deleteById(Long id);
    Optional<User> findById(Long id);

}
