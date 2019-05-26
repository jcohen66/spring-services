package com.katonahcomputing.authservice.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @RequestMapping({"/", "index"})
    public String home() {
        return "index";
    }

    @RequestMapping("/private")
    public String webPrivate() {
        return "private";
    }

    @RequestMapping("/public")
    public String loginpub() {
        return "public";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}