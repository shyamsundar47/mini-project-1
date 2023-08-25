package com.minipro.minipro.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minipro.minipro.model.Plan;
import com.minipro.minipro.repository.PlanCategoryRepo;
import com.minipro.minipro.repository.PlanRepo;
import com.minipro.minipro.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService{
    @Autowired
    private PlanRepo planRepo;

    @Autowired
    private PlanCategoryRepo categoryRepo;

    @Override
    public boolean deletePlanById(Integer planId) {
        if(getPlanById(planId)!=null){
            planRepo.deleteById(planId);
            return true;
        }
        return false;
    }

    @Override
    public List<Plan> getAllPlans() {
        // List<Plan> allPlan = new ArrayList<>();
        // planRepo.findAll().forEach(plan -> allPlan.add(plan));
        return planRepo.findAll();
    }

    @Override
    public Plan getPlanById(Integer planId) {
        Optional<Plan> findById = planRepo.findById(planId);
        return findById.isPresent() ? findById.get() : null;
    }

    @Override
    public Map<Integer, String> getPlanCategory() {
        Map<Integer , String> allCategory = new HashMap<>();
        categoryRepo.findAll().forEach(category -> allCategory.put(category.getCategoryId(), category.getCategoryName()));
        return allCategory;
    }

    @Override
    public boolean planStatusChange(Integer planId, String activeSw) {
        Plan plan = getPlanById(planId);
        if(plan!=null){
            plan.setActiveSW(activeSw);
            planRepo.save(plan);
            return true;
        }
        return false;
    }

    @Override
    public boolean savePlan(Plan plan) {
        Plan savedPlan = planRepo.save(plan);
        return savedPlan.getPlanId()!=null ? true : false;
    }
    
}
