package com.dars.backend.controller;

import com.dars.backend.entity.DisasterEvent;
import com.dars.backend.service.DisasterEventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class DisasterEventController {

    private final DisasterEventService disasterEventService;

    public DisasterEventController(DisasterEventService disasterEventService) {
        this.disasterEventService = disasterEventService;
    }

    @GetMapping
    public List<DisasterEvent> getAllEvents() {
        return disasterEventService.getAllEvents();
    }
}
