package com.example.demo.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FoodItems;


public interface FoodRepository extends JpaRepository<FoodItems, Integer> {

}
