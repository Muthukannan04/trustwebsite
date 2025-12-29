package com.trust.trustwebsite.controller;

import com.trust.trustwebsite.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EventService eventService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "admin-dashboard";
    }
    @GetMapping("/admin/login")
    public String loginPage() {
        return "admin-login";
    }

}
