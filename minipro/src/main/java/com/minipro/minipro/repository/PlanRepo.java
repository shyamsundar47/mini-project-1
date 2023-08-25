package com.minipro.minipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minipro.minipro.model.Plan;

public interface PlanRepo extends JpaRepository<Plan,Integer>{
    
}
