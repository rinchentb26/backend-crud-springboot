package com.fullstack.login.demo.controllers;

import com.fullstack.login.demo.entities.User;
import com.fullstack.login.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    StudentService studentService;
    @PostMapping("/user/save")
        public User saveUser(@RequestBody User user) {
        System.out.println(user);
        return studentService.saveUser(user);
    }
    @PostMapping("/user/login")
        public ResponseEntity<String> authenticateUser(@RequestBody User user){
           boolean passedAuthentication = studentService.authenticateUser(user);
           if(passedAuthentication)
               return ResponseEntity.ok("Authentication successful!");
           else
               return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication Failed!");
    }
}
