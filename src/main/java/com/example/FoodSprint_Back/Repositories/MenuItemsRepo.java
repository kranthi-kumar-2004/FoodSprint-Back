package com.example.FoodSprint_Back.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodSprint_Back.Entity.MenuItems;

public interface MenuItemsRepo
        extends JpaRepository<MenuItems, Long> {

    List<MenuItems> findByRestaurantId(Long restaurantId);

}