package com.firstspringapp.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class DemoController {

    @GetMapping("/home")
    public String demo() {
        return new String("Hello! Welcome to Java World  >>>>>  Udaya");
    }

}
