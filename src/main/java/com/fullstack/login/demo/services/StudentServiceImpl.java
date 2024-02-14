package com.fullstack.login.demo.services;

import com.fullstack.login.demo.entities.User;
import com.fullstack.login.demo.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;
    @Override
    public User saveUser(User user) {
        return studentRepo.save(user);
    }

    @Override
    public boolean authenticateUser(User user) {
        User realUser = studentRepo.findByEmailId(user.getEmailId());
        System.out.println(realUser);
        if(realUser!=null && user.getPassword().equals(realUser.getPassword())){
            System.out.println("AUTHENTICATED");
            return true;
        }
        else{
            System.out.println("FAILED");
            return false;
        }

    }
}
