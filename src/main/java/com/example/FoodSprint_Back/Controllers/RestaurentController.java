package com.example.FoodSprint_Back.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class RestaurentController {
    @GetMapping("/restaurent/")
    public String greet(){
        return "restaurent api";
    }
}
