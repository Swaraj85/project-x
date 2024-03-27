package com.swaraj.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String getHome() {
        return "home page";
    }

    @GetMapping("/user")
    public String getUserPage() {
        return "user page";
    }

    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin page";
    }

}
