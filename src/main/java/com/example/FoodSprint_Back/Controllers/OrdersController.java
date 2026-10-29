package com.example.FoodSprint_Back.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class OrdersController {
    @GetMapping("/orders/")
    public String greet(){
        return "orders api";
    }
}
