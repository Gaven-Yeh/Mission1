package com.gaven.resourceserver.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/resource/user")
    public String user(@AuthenticationPrincipal Jwt jwt) {
        return String.format("User resource accessed by: %s (with subjectId: %s)" ,
                jwt.getClaims().get("user_name"),
                jwt.getSubject());
    }

    @GetMapping("/resource/admin")
    public String admin(@AuthenticationPrincipal Jwt jwt) {
        return String.format("Admin resource accessed by: %s (with subjectId: %s)" ,
                jwt.getClaims().get("user_name"),
                jwt.getSubject());
    }

    @GetMapping("/resource/home")
    public String home(@AuthenticationPrincipal Jwt jwt) {
        return String.format("Home resource accessed by: %s (with subjectId: %s)" ,
                jwt.getClaims().get("user_name"),
                jwt.getSubject());
    }
}
