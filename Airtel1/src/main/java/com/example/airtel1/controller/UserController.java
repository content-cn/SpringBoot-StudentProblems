package com.example.airtel1.controller;

import com.example.airtel1.domain.CorporateUser;
import com.example.airtel1.domain.NormalUser;
import com.example.airtel1.domain.User;
import com.example.airtel1.service.NormalUserRegisterationService;
import com.example.airtel1.service.RegisterationService;
import com.example.airtel1.service.corporateUserRegisterationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {
    @Autowired
    NormalUserRegisterationService registerationService;
    @Autowired
    corporateUserRegisterationService corporateUserRegisterationService;
    @RequestMapping("normaluser")
    String getNormalUserPage(){
        return "normaluserselect";
    }
    @RequestMapping("corporateuser")
    String getCorporateUserPage(){
        return "corporateuserselect";
    }
    @RequestMapping(value = "/signup",method = RequestMethod.GET)

    public String getSignupPage(Model normalUserModel) {
        User user = registerationService.getNewUser();
        normalUserModel.addAttribute("user",user);
        return "signup";
    }

    @RequestMapping("/register")
    public String getnormalUserSelect(@ModelAttribute("user") NormalUser normalUser ){
        if(registerationService.registerUser(normalUser.getName(),normalUser.getPlan(),normalUser.getNumber())){
            return "normaluserplan";
        }
        return "normaluserselect";
    }

    @RequestMapping(value = "/signup-corporate",method = RequestMethod.GET)
    public String getCorporateSignupPage(Model corporateUserModel) {
       User user = corporateUserRegisterationService.getNewUser();
        corporateUserModel.addAttribute("corporate",user);
        return "signupcorporate";
    }

    @RequestMapping("/corporateregister")
    public String getcorporateUserSelect(@ModelAttribute("user")CorporateUser corporateUser){
        if(corporateUserRegisterationService.registerUser(corporateUser.getName(),corporateUser.getPlan(),corporateUser.getNumber())){
            return "corporateuserplan";
        }
        return "corporateuserplan";
    }



}
