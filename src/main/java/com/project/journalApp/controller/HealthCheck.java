package com.project.journalApp.controller;

import com.project.journalApp.entity.JournalEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")

public class HealthCheck {
    @GetMapping(value = "/health-check")
    public String healthCheck() {
        return "OK";
    }
}
