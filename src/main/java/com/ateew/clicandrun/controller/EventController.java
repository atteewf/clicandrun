package com.ateew.clicandrun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ateew.clicandrun.model.Event;
import com.ateew.clicandrun.service.EventService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/event")
    public Iterable<Event> getEvent() {
        return eventService.getEvent();
    }

    @GetMapping("/event/{id}")
    public Event getOneEvent(@PathVariable Long id) {
        return eventService.getOneEvent(id);
    }


    @PostMapping("/event")
    public Event createEvent(@RequestBody Event event) {
        return eventService.saveEvent(event);
    }
    @PutMapping("/event/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
        event.setId(id);
        return eventService.saveEvent(event);
    }

    @DeleteMapping("/event/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }


}