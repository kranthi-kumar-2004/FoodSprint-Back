// package com.example.FoodSprint_Back.Controllers;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// // import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.FoodSprint_Back.Entity.Restaurants;
// import com.example.FoodSprint_Back.Repositories.RestRepo;
// import java.util.*;
// @RestController
// @RequestMapping ("/api")
// public class RestaurentController {

//     @Autowired
//     private RestRepo repo;
//     private Map<String,String> mm = new HashMap<>();
//     @PostMapping("/login")
//     public String addRestaurant(@RequestBody Map<String, String> map) {
//         String n = "resh";
//         String m = "123";
//         if(n.equals(map.get("username")) && m.equals(map.get("password"))){
//             mm.put("username",n);
//             mm.put("password",m);
//             return "Success";
//         }
//         return "Fail";
//     }

//     @GetMapping("/get")
//     public List<Map<String,String>> getAll(){
//         return List.of(mm);
//     }
    
// }