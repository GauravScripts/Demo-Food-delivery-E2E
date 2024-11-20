package com.udemy.resturantlisting.service;

import com.udemy.resturantlisting.dto.ResturantDTO;
import com.udemy.resturantlisting.entity.Restaurant;
import com.udemy.resturantlisting.mapper.RestaurantMapper;
import com.udemy.resturantlisting.repo.ResturantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
