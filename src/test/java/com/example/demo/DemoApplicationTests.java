package com.example.demo;

import com.example.demo.dao.UserRepo;
import com.example.demo.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserRepo userRepo;

    @Test
    void testFindByIdAndNameAndAge() {
        User user = userRepo.findByIdAndNameAndAge(1L, "George", 20);
        System.out.println("==========>>>>>>>>>>" + user.toString());
    }

    @Test
    void testSave() {
        User user = new User();
        user.setAge(6);
        user.setName("Doris");
        userRepo.save(user);
        Assert.assertNotNull(user.getId());
        System.out.println("==========>>>>>>>>>>" + user.toString());
    }

    @Test
    void testFindById() {
        User user = userRepo.findById(1L).get();
        Assert.assertTrue(user.getAge() == 20);
    }

    @Test
    void testFindByAge() {
        User user = userRepo.findByAgeIsGreaterThan( 30);
        Assert.assertTrue(user == null);
    }

    @Test
    void testOrderBy() {
        List<User> users = userRepo.findAllByAgeIsGreaterThanOrderByAge(10);
        users.forEach(user -> System.out.println(user));
    }
}
