package com.udemy.foodcatalouge.mapper;

import com.udemy.foodcatalouge.dto.FoodItemDTO;
import com.udemy.foodcatalouge.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {
    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);
    FoodItem mapFoodItemDTOtoFoodItem(FoodItemDTO foodItemDTO);
    FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem);

}
