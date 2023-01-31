package com.example.airtel1.controller;

import com.example.airtel1.domain.CorporatePlan;
import com.example.airtel1.domain.NormalPlan;
import com.example.airtel1.domain.Plan;
import com.example.airtel1.service.NormalPlanRegisterationService;
import com.example.airtel1.service.PlanRegisterationService;
import com.example.airtel1.service.corporatePlanRegisterationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class planController {

    @Autowired
    NormalPlanRegisterationService planRegisterationService;
    @Autowired
    corporatePlanRegisterationService corporatePlanRegisterationService;
    @RequestMapping("/done")
    public String getNormalUserPage(Model normalplanModel){
        Plan plan = planRegisterationService.getNewNormalPlan();
        normalplanModel.addAttribute("normalplan",plan);
        return "normaluserplandetails";
    }
    @RequestMapping("/registernormalplan")
    public String getNormalUserDonePage(@ModelAttribute("donenormaluser")NormalPlan normalPlan){
        if(planRegisterationService.registerPlan(normalPlan.getData(), normalPlan.getDuration(), normalPlan.getSpeed(),normalPlan.getCalls())){
            return "success";
        }
        return "success";
    }
    @RequestMapping("/corporateplans")
    public String getCorporatePlanDetails(Model corporateplanModel){
        Plan plan = corporatePlanRegisterationService.getNewNormalPlan();
        corporateplanModel.addAttribute("corporateplan",plan);
        return "corporateuserplandetails";
    }

    @RequestMapping("/registercorporateplan")

    public String getCorporateUserDonePage(@ModelAttribute("donecorporateuser") CorporatePlan corporatePlan){
        if(corporatePlanRegisterationService.registerPlan(corporatePlan.getData(), corporatePlan.getDuration(), corporatePlan.getSpeed(),corporatePlan.getCalls())){
            return "success";
        }
        return "success";
    }
}
