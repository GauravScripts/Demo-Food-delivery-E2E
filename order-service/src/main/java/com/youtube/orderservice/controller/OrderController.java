package com.youtube.orderservice.controller;

import com.youtube.orderservice.dto.OrderDTO;
import com.youtube.orderservice.dto.OrderDTOfromFE;
import com.youtube.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOfromFE orderDTOfromFE) {
       OrderDTO orderDTO = orderService.saveOrder(orderDTOfromFE);
       return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
    }
}
