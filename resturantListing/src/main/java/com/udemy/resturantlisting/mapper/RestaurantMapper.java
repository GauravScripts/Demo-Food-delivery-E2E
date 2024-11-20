package com.udemy.resturantlisting.mapper;

import com.udemy.resturantlisting.dto.ResturantDTO;
import com.udemy.resturantlisting.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);
    ResturantDTO mapRestaurantToResturantDTO(Restaurant restaurant);
    Restaurant mapResturantDTOToResturant(ResturantDTO resturantDTO);

}
