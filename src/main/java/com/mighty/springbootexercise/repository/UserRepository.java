package com.mighty.springbootexercise.repository;

import com.mighty.springbootexercise.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findBySex(Integer sex);

}
