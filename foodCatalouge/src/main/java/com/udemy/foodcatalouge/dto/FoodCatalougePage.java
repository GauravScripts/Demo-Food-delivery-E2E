package com.udemy.foodcatalouge.dto;

import com.udemy.foodcatalouge.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodCatalougePage {
    private List<FoodItem> foodItemsList;
    private Resturant resturant;
}
