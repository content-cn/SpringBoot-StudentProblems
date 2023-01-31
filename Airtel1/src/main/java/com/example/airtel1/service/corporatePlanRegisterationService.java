package com.example.airtel1.service;

import com.example.airtel1.domain.CorporatePlan;
import com.example.airtel1.domain.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class corporatePlanRegisterationService implements PlanRegisterationService {
    @Autowired
    Plan CorporatePlan;
    @Override
    public Boolean registerPlan(Integer data, Integer duration, String speed, String calls) {
        CorporatePlan.createPlan(data,duration,speed,calls);
        return CorporatePlan.savePlanDetails();
    }

    @Override
    public Plan getNewNormalPlan() {
        return CorporatePlan;
    }
}
