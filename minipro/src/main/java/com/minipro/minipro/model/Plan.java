package com.minipro.minipro.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "PLAN_MASTER")
@Data
public class Plan {

    @Id
    @GeneratedValue
    @Column(name="PLAN_ID")
    private Integer planId;

    @Column(name="PLAN_NAME")
    private String planName;

    @Column(name="PLAN_START_DATE")
    private LocalDate planStartDate;

    @Column(name="PLAN_END_DATE")
    private LocalDate planEnDate;

    @Column(name="ACTIVE_SW")
    private String activeSW;

    @Column(name="PLAN_CATEGORY_ID")
    private Integer planCategoryId;

    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "UPDATED_BY")
    private String updatedBy;


    @Column(name = "CREATED_DATE" ,updatable = false)
    @CreationTimestamp
    private LocalDate createdDate;

    @Column(name = "UPDATED_DATE" ,insertable = false)
    @UpdateTimestamp
    private LocalDate updatedDate;

}
