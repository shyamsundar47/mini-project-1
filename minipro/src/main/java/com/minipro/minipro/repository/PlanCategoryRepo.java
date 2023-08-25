package com.minipro.minipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minipro.minipro.model.PlanCategory;

public interface PlanCategoryRepo extends JpaRepository<PlanCategory,Integer>{
    
}
