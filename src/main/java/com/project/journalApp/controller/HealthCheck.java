package com.project.journalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api")
public class HealthCheck {

    @GetMapping(value = "/health-check")
    public String healthCheck() {
        return "OK";
    }
}
