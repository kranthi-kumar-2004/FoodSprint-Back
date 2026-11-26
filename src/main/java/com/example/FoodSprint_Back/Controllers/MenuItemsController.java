package com.example.FoodSprint_Back.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.FoodSprint_Back.Entity.MenuItems;
import com.example.FoodSprint_Back.Entity.Restaurants;

import com.example.FoodSprint_Back.Repositories.MenuItemsRepo;
import com.example.FoodSprint_Back.Repositories.RestaurantsRepo;

@RestController
@RequestMapping("/api/menu-items")
@CrossOrigin(origins = "*")
public class MenuItemsController {

    private final MenuItemsRepo menuRepo;
    private final RestaurantsRepo restaurantRepo;

    public MenuItemsController(
            MenuItemsRepo menuRepo,
            RestaurantsRepo restaurantRepo) {

        this.menuRepo = menuRepo;
        this.restaurantRepo = restaurantRepo;
    }

    @PostMapping("/restaurant/{restaurantId}")
    public MenuItems addMenuItem(
            @PathVariable Long restaurantId,
            @RequestBody MenuItems menuItem) {

        Restaurants restaurant = restaurantRepo.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        menuItem.setRestaurant(restaurant);

        return menuRepo.save(menuItem);
    }

    @GetMapping
    public List<MenuItems> getAllMenuItems() {
        return menuRepo.findAll();
    }

    @GetMapping("/restaurant/{restaurantId}")
    public List<MenuItems> getMenuByRestaurant(
            @PathVariable Long restaurantId) {

        return menuRepo.findByRestaurantId(restaurantId);
    }

    @GetMapping("/{id}")
    public MenuItems getMenuItemById(@PathVariable Long id) {

        return menuRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu item not found"));
    }

    @PutMapping("/{id}")
    public MenuItems updateMenuItem(
            @PathVariable Long id,
            @RequestBody MenuItems menuItem) {

        MenuItems existing = menuRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu item not found"));

        existing.setName(menuItem.getName());
        existing.setDescription(menuItem.getDescription());
        existing.setCategory(menuItem.getCategory());
        existing.setPrice(menuItem.getPrice());
        existing.setImageUrl(menuItem.getImageUrl());
        existing.setIsVegetarian(menuItem.getIsVegetarian());
        existing.setIsAvailable(menuItem.getIsAvailable());
        existing.setIsBestseller(menuItem.getIsBestseller());
        existing.setPreparationTime(menuItem.getPreparationTime());

        return menuRepo.save(existing);
    }

    @DeleteMapping("/{id}")
    public String deleteMenuItem(@PathVariable Long id) {

        if (!menuRepo.existsById(id)) {
            throw new RuntimeException("Menu item not found");
        }

        menuRepo.deleteById(id);

        return "Menu item deleted successfully";
    }
}