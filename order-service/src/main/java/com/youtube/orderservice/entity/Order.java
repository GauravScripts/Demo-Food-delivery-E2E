package com.youtube.orderservice.entity;

import com.youtube.orderservice.dto.FoodItemDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer orderId;
    private List<FoodItemDTO> foodItemList;

}
