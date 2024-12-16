package com.youtube.orderservice.repo;

import com.youtube.orderservice.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepo extends MongoRepository<Order, Integer> {
}
