package com.example.demo.dao;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    // 通过三个列查找User
    User findByIdAndNameAndAge(Long id, String name, Integer age);

    User findByAgeIsGreaterThan(Integer minAge);

    List<User> findAllByAgeIsGreaterThanOrderByAge(Integer minAge);
}
