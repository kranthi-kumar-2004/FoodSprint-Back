package com.example.FoodSprint_Back.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.FoodSprint_Back.Entity.Restaurants;
import com.example.FoodSprint_Back.Repositories.RestRepo;

@RestController
public class RestaurentController {

    @Autowired
    private RestRepo repo;

    @PostMapping("/api/add")
    public Restaurants addRestaurant(@RequestBody Restaurants rest) {

        return repo.save(rest);
    }
    
}