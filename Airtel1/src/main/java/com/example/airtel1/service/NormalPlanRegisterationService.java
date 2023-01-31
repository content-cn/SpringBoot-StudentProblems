package com.example.airtel1.service;

import com.example.airtel1.domain.NormalPlan;
import com.example.airtel1.domain.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class NormalPlanRegisterationService implements PlanRegisterationService{
    @Autowired
    Plan NormalPlan;
    @Override
    public Boolean registerPlan(Integer data, Integer duration, String speed, String calls) {
        NormalPlan.createPlan(data,duration,speed,calls);
        return NormalPlan.savePlanDetails();
    }

    @Override
    public Plan getNewNormalPlan() {
        return NormalPlan;
    }
}
