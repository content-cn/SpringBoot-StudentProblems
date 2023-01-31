package com.example.airtel1.service;

import com.example.airtel1.domain.NormalPlan;
import com.example.airtel1.domain.NormalUser;
import com.example.airtel1.domain.Plan;

public interface PlanRegisterationService {
    public Boolean registerPlan(Integer data,Integer duration,String speed,String calls);
    public Plan getNewNormalPlan();
}
