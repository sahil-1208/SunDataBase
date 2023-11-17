package com.customer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Value("${app.login_id}")
    private String login_id;

    @Value("${app.password}")
    private String appPassword;

    public boolean authenticate(String login_id, String password) {
        return login_id.equals(login_id) && appPassword.equals(password);
    }
}
