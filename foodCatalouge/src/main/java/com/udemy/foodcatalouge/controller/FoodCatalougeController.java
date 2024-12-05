package com.udemy.foodcatalouge.controller;

import com.udemy.foodcatalouge.service.FoodCatalougeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foodcatalouge")
public class FoodCatalougeController {
    @Autowired
    private FoodCatalougeService foodCatalougeService;
}
