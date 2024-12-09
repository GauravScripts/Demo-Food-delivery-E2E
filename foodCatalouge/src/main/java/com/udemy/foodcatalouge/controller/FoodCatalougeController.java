package com.udemy.foodcatalouge.controller;

import com.udemy.foodcatalouge.dto.FoodCatalougePage;
import com.udemy.foodcatalouge.dto.FoodItemDTO;
import com.udemy.foodcatalouge.service.FoodCatalougeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodcatalouge")
public class FoodCatalougeController {
    @Autowired
    private FoodCatalougeService foodCatalougeService;


    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO) {
        return ResponseEntity.ok(foodCatalougeService.addFoodItem(foodItemDTO));
    }


    @GetMapping("/getFoodItem/{resturantId}")
    public ResponseEntity<FoodCatalougePage> fetchRestaurantDetailsWithFoodMenu(@PathVariable Integer resturantId) {
        FoodCatalougePage foodCatalougePage = foodCatalougeService.fetchRestaurantDetailsWithFoodMenu(resturantId);
        return new ResponseEntity<>(foodCatalougePage, HttpStatus.FOUND);
    }
}
