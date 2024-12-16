package com.youtube.orderservice.service;

import com.youtube.orderservice.dto.OrderDTO;
import com.youtube.orderservice.dto.OrderDTOfromFE;
import com.youtube.orderservice.dto.UserDTO;
import com.youtube.orderservice.entity.Order;
import com.youtube.orderservice.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    SequenceGenerator sequenceGenerator;


    @Autowired
    private RestTemplate restTemplate;


    public OrderDTO saveOrder(OrderDTOfromFE orderDTOfromFE) {
        Integer newOrderId = sequenceGenerator.generateNextOrderID();
        UserDTO userDTO = fetchUserDetailsfromuserId(orderDTOfromFE.getUserId());
        Order ordertoSave = new Order(newOrderId, orderDTOfromFE.getFoodItemDTOList(), orderDTOfromFE.getRestaurant(), userDTO);
    }

    private UserDTO fetchUserDetailsfromuserId(Integer userId) {
return restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/"+userId, UserDTO.class);
    }
}
