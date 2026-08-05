package com.ateew.clicandrun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ateew.clicandrun.model.Event;
import com.ateew.clicandrun.service.EventService;
import com.ateew.clicandrun.dto.EventDto;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

   @GetMapping("/event")
public Page<Event> getEvent(Pageable pageable) {
    return eventService.getEvent(pageable);
}

    @GetMapping("/event/{id}")
    public Event getOneEvent(@PathVariable Long id) {
        return eventService.getOneEvent(id);
    }


    @PostMapping("/event")
    public Event createEvent(@Valid @RequestBody EventDto eventDto) {
        return eventService.saveEvent(eventDto,null);
    }
    @PutMapping("/event/{id}")
    public Event updateEvent(@PathVariable Long id, @Valid @RequestBody EventDto eventDto) {
        return eventService.saveEvent(eventDto,id);
    }

    @DeleteMapping("/event/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }


}