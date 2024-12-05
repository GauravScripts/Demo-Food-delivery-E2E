package com.udemy.foodcatalouge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Resturant {
    private int id;
    private String name;
    private String address;
    private String city;
    private String restaurantType;
}
