package com.trust.trustwebsite.controller;

import com.trust.trustwebsite.service.EventService;   // ⭐ IMPORT FIX
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private EventService eventService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "index";
    }
}
