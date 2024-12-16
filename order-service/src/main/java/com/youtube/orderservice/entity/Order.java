package com.youtube.orderservice.entity;

import com.youtube.orderservice.dto.FoodItemDTO;
import com.youtube.orderservice.dto.Restaurant;
import com.youtube.orderservice.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "order")
public class Order {
    private Integer orderId;
    private List<FoodItemDTO> foodItemList;
    private Restaurant restaurant;
    private UserDTO user;

}
