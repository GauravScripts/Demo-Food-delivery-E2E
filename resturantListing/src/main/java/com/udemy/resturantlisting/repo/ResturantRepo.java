package com.udemy.resturantlisting.repo;

import com.udemy.resturantlisting.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResturantRepo extends JpaRepository<Restaurant, Integer> {
}
