package com.example.FoodSprint_Back.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodSprint_Back.Entity.Restaurants;

public interface RestRepo extends JpaRepository<Restaurants,Integer>{
    
}
