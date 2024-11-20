package com.udemy.resturantlisting.service;

import com.udemy.resturantlisting.dto.ResturantDTO;
import com.udemy.resturantlisting.entity.Restaurant;
import com.udemy.resturantlisting.mapper.RestaurantMapper;
import com.udemy.resturantlisting.repo.ResturantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResturantService {
    @Autowired
    private ResturantRepo resturantRepo;

    public List<ResturantDTO> fetchAllResturants() {
    List<Restaurant> restaurants = resturantRepo.findAll();
    return restaurants.parallelStream()
            .map(RestaurantMapper.INSTANCE::mapRestaurantToResturantDTO)
            .collect(Collectors.toList());
    }

  public ResturantDTO addResturant(ResturantDTO resturantDTO) {
    Restaurant restaurant = RestaurantMapper.INSTANCE.mapResturantDTOToResturant(resturantDTO);
    Restaurant savedRestaurant = resturantRepo.save(restaurant);
    return RestaurantMapper.INSTANCE.mapRestaurantToResturantDTO(savedRestaurant);
  }

    public ResponseEntity<ResturantDTO> fetchResturantById(Integer id) {
        Optional<Restaurant> restaurant = resturantRepo.findById(id);
        return restaurant.map(value -> new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToResturantDTO(value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
