package com.minipro.minipro.service;

import java.util.List;
import java.util.Map;

import com.minipro.minipro.model.Plan;

public interface PlanService {

    public Map<Integer,String> getPlanCategory();

    public boolean savePlan(Plan plan);

    public List<Plan> getAllPlans();

    public Plan getPlanById(Integer planId);

    public boolean deletePlanById(Integer planId);

    public boolean planStatusChange(Integer planId , String activeSw);
    
}
