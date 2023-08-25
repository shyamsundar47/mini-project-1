package com.minipro.minipro.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.minipro.minipro.constant.AppConstants;
import com.minipro.minipro.model.Plan;
import com.minipro.minipro.properties.AppProperties;
import com.minipro.minipro.service.PlanService;


@RestController
public class PlanRestController {

    private PlanService planService;

    private Map<String,String> messages = new HashMap<>();

    public PlanRestController(PlanService planService,AppProperties appProperties){
        this.planService = planService;
        this.messages = appProperties.getMessages();
        System.out.println(this.messages);
    }

    @GetMapping("/categories")
    public ResponseEntity<Map<Integer,String>> planCategories(){
        return new ResponseEntity<>(planService.getPlanCategory(),HttpStatus.OK);
    }

    @PostMapping("/plan")
    public ResponseEntity<String> savePlan(@RequestBody Plan plan){
        String responseMsg = AppConstants.EMPTY_STR;
        responseMsg = planService.savePlan(plan) ? messages.get(AppConstants.PLAN_SAVE_SUCCESS) :  messages.get(AppConstants.PLAN_SAVE_FAIL);
        return new ResponseEntity<>(responseMsg,HttpStatus.CREATED);
    }

    @GetMapping("/plans")
    public ResponseEntity<List<Plan>> getPlans(){
        return new ResponseEntity<List<Plan>>(planService.getAllPlans(),HttpStatus.OK);
    }

    @GetMapping("/plan/{planId}")
    public ResponseEntity<Plan> editPlan(@PathVariable Integer planId){
        return new ResponseEntity<>(planService.getPlanById(planId),HttpStatus.OK);
    }

    @DeleteMapping("/plan/{planId}")
    public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
       String responseMsg = AppConstants.EMPTY_STR;
       responseMsg = planService.deletePlanById(planId) ? messages.get(AppConstants.PLAN_DELETE_SUCCESS) : messages.get(AppConstants.PLAN_DELETE_FAIL);
        return new ResponseEntity<>(responseMsg,HttpStatus.OK);
    }

    @PutMapping("/plan")
    public ResponseEntity<String> updatePlan(@RequestBody Plan plan){
         String responseMsg = AppConstants.EMPTY_STR;
       responseMsg = planService.savePlan(plan) ? messages.get(AppConstants.PLAN_UPDATE_SUCCESS) : messages.get(AppConstants.PLAN_UPDATE_FAIL);
        return new ResponseEntity<>(responseMsg,HttpStatus.OK);
    }

    @PutMapping("/status-change/{planId}/{status}")
    public ResponseEntity<String> statusChange(@PathVariable Integer planId, @PathVariable String status ){
        String responseMsg = AppConstants.EMPTY_STR;
        responseMsg = planService.planStatusChange(planId, status) ? messages.get(AppConstants.PLAN_STATUS_CHANGED) : messages.get(AppConstants.PLAN_STATUS_CHANGED_FAIL);
        return new ResponseEntity<>(responseMsg,HttpStatus.OK);
    }
    
}
