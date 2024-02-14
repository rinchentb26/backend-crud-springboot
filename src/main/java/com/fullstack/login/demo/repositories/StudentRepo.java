package com.fullstack.login.demo.repositories;

import com.fullstack.login.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<User,Integer> {
    boolean existsByEmailId(String emailId);
    User findByEmailId(String emailId);
}
