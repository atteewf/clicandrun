package com.ateew.klikego_lite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ateew.klikego_lite.model.Event;
import com.ateew.klikego_lite.service.EventService;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/event")
    public Iterable<Event> getEvent() {
        return eventService.getEvent();
    }
}