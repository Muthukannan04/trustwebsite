package com.trust.trustwebsite.controller;

import com.trust.trustwebsite.model.Event;
import com.trust.trustwebsite.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/events")
public class EventController {

    @Autowired
    private EventService eventService;

    // Show add event form
    @GetMapping("/add")
    public String addEventForm(Model model) {
        model.addAttribute("event", new Event());
        return "admin-add-event";
    }

    // Save event (Add + Update)
    @PostMapping("/save")
    public String saveEvent(@ModelAttribute Event event) {
        eventService.saveEvent(event);
        return "redirect:/admin/events/list";
    }

    // View events
    @GetMapping("/list")
    public String listEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "admin-event-list";
    }

    // Show edit form
    @GetMapping("/edit/{id}")
    public String editEvent(@PathVariable Long id, Model model) {
        Event event = eventService.getEventById(id);
        model.addAttribute("event", event);
        return "admin-edit-event";
    }

    // Delete event
    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "redirect:/admin/events/list";
    }
}
