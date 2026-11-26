package com.example.FoodSprint_Back.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.FoodSprint_Back.Entity.Restaurants;
import com.example.FoodSprint_Back.Repositories.RestaurantsRepo;

@RestController
@RequestMapping("/api/restaurants")
@CrossOrigin(origins = "*")
public class RestaurantsController {
    @Autowired 
    private RestaurantsRepo restaurantRepo;

    // public RestaurantsController(RestaurantsRepo restaurantRepo) {
    //     this.restaurantRepo = restaurantRepo;
    // }

    @PostMapping("/add")
    public Restaurants addRestaurant(@RequestBody Restaurants restaurant) {
        return restaurantRepo.save(restaurant);
    }

    @GetMapping("/all")
    public List<Restaurants> getAllRestaurants() {
        return restaurantRepo.findAll();
    }

    // @GetMapping("/{id}")
    // public Restaurants getRestaurantById(@PathVariable Long id) {
    //     return restaurantRepo.findById(id)
    //             .orElseThrow(() -> new RuntimeException("Restaurant not found"));
    // }

    // @PutMapping("/{id}")
    // public Restaurants updateRestaurant(
    //         @PathVariable Long id,
    //         @RequestBody Restaurants restaurant) {

    //     Restaurants existing = restaurantRepo.findById(id)
    //             .orElseThrow(() -> new RuntimeException("Restaurant not found"));

    //     existing.setName(restaurant.getName());
    //     existing.setDescription(restaurant.getDescription());
    //     existing.setAddress(restaurant.getAddress());
    //     existing.setCity(restaurant.getCity());
    //     existing.setLatitude(restaurant.getLatitude());
    //     existing.setLongitude(restaurant.getLongitude());
    //     existing.setPhone(restaurant.getPhone());
    //     existing.setEmail(restaurant.getEmail());
    //     existing.setImageUrl(restaurant.getImageUrl());
    //     existing.setDeliveryTime(restaurant.getDeliveryTime());
    //     existing.setDeliveryFee(restaurant.getDeliveryFee());
    //     existing.setMinimumOrder(restaurant.getMinimumOrder());
    //     existing.setIsOpen(restaurant.getIsOpen());

    //     return restaurantRepo.save(existing);
    // }

    // @DeleteMapping("/{id}")
    // public String deleteRestaurant(@PathVariable Long id) {

    //     if (!restaurantRepo.existsById(id)) {
    //         throw new RuntimeException("Restaurant not found");
    //     }

    //     restaurantRepo.deleteById(id);

    //     return "Restaurant deleted successfully";
    // }
}