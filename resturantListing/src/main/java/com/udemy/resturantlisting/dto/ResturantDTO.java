package com.udemy.resturantlisting.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResturantDTO {
    private int id;
    private String name;
    private String address;
    private String city;
    private String restaurantType;
}
