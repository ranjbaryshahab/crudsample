package com.shahab.crudsample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class HomeController {
    @GetMapping("/")
    private RedirectView redirectToSwagger() {
        return new RedirectView("http://localhost:7788/swagger-ui.html");
    }
}