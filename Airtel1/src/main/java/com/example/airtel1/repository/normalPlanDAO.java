package com.example.airtel1.repository;

import com.example.airtel1.domain.NormalPlan;
import com.example.airtel1.domain.NormalUser;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class normalPlanDAO implements DAO<NormalPlan> {
    private List<NormalPlan> normalPlanList=new ArrayList<>();


    @Override
    public int save(NormalPlan normalPlan) {
        int normalPlanId= normalPlanList.size();
        normalPlan.setPlanId(normalPlanId);
        normalPlanList.add(normalPlan);
        System.out.println("plan saved");
        return normalPlanId;
    }
}
