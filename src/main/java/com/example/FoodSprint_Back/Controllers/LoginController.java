package com.example.FoodSprint_Back.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FoodSprint_Back.Entity.User;
import com.example.FoodSprint_Back.Repositories.LoginRepo;

@RestController 
@RequestMapping ("/api")
@CrossOrigin (origins="*")
public class LoginController {
    @Autowired 
    LoginRepo repo;
    @Autowired 
    PasswordEncoder passwordEncoder;
    @PostMapping("/register")
    public String register(@RequestBody User user){
        User ob=repo.findByEmail(user.getEmail()).orElse(null);
        if(ob != null)
            return "User Already exists";
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
        return "Register Successful";
    }

    @PostMapping ("/login")
    public String login(@RequestBody User user){
        User obj = repo.findByEmail(user.getEmail()).orElse(null);
        if(obj != null){
            if(passwordEncoder.matches(user.getPassword(),obj.getPassword()))
                return "Login successful";
        }
        return "Invalid Credentials";
    }


}
