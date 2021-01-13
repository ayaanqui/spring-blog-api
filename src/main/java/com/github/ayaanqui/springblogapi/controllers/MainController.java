package com.github.ayaanqui.springblogapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping(path = "/")
public class MainController {
    @GetMapping
    public Object getHome() {
        return new Object() {
            public String message = "Spring Blog API";
        };
    }
}
