package com.labs.employeeservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestScope
public class MessageController {
    @Value("${spring.message}")
    private String message;

    @GetMapping("/user/test-message")
    public String showMessage(){
        return message;
    }
}
