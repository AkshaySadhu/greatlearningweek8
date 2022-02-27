package com.greatlearning.week8.service;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}
