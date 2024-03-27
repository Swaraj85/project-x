package com.swaraj.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureRestRoleController {

    @GetMapping("/")
    public String home(){
        return "Hello!!";
    }

    @GetMapping("/user")
    public String welcomeUser() {
        return "Hello user!!";
    }

    @GetMapping("/admin")
    public String welcomeAdmin() {
        return "Hello admin!!";
    }
}
