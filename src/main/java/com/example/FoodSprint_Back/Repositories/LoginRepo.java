package com.example.FoodSprint_Back.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodSprint_Back.Entity.User;

public interface LoginRepo extends JpaRepository<User, Integer>{
    Optional<User> findByEmail(String s);
}
