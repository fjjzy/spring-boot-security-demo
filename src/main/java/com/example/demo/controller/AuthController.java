package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/status")
    public Map<String, Object> getLoginStatus() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Map<String, Object> status = new HashMap<>();
        
        status.put("isAuthenticated", authentication != null && authentication.isAuthenticated());
        status.put("username", authentication.getName());
        status.put("authorities", authentication.getAuthorities());
        
        return status;
    }
}
