package com.example.airtel1.domain;

public interface User {
    public Boolean saveUserDetails();
    public void createUser(String name,String plan,Integer number);
}
