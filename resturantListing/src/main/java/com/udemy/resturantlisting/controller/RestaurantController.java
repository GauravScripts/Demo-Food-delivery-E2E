package com.udemy.resturantlisting.controller;

import com.udemy.resturantlisting.dto.ResturantDTO;
import com.udemy.resturantlisting.service.ResturantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addResturant")
    public ResponseEntity<ResturantDTO> addResturant(@RequestBody ResturantDTO resturantDTO) {
        return new ResponseEntity<>(resturantService.addResturant(resturantDTO), HttpStatus.CREATED);

    }

    @GetMapping("/fetchResturantById/{id}")
    public ResponseEntity<ResturantDTO> fetchResturantById(@PathVariable Integer id) {
        return new ResponseEntity<>(resturantService.fetchResturantById(id).getBody(), resturantService.fetchResturantById(id).getStatusCode());

    }
}
