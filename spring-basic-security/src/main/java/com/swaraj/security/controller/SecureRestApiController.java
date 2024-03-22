package com.swaraj.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class SecureRestApiController {

    @GetMapping("/getMsg")
    public String greetings() {
        return "spring security";
    }
}
