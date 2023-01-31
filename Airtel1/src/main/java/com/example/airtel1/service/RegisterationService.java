package com.example.airtel1.service;

import com.example.airtel1.domain.User;

public interface RegisterationService {
    public Boolean registerUser(String name,String plan,Integer number);
    public User getNewUser();
}
