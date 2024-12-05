package com.udemy.foodcatalouge.repo;

import com.udemy.foodcatalouge.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem, Integer> {

}
