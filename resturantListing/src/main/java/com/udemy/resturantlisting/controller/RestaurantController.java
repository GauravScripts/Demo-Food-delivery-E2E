package com.udemy.resturantlisting.controller;

import com.udemy.resturantlisting.dto.ResturantDTO;
import com.udemy.resturantlisting.service.ResturantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resturant")
public class RestaurantController {
    @Autowired
    private ResturantService resturantService;


    @GetMapping("/fetchAllResturants")
    public ResponseEntity<List<ResturantDTO>> fetchAllResturants() {
        return ResponseEntity.ok(resturantService.fetchAllResturants());
    }

}