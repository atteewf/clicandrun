package com.ateew.clicandrun.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ateew.clicandrun.exception.EventNotFoundException;
import com.ateew.clicandrun.model.Event;
import com.ateew.clicandrun.repository.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event getOneEvent(final long id) {
        return eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException(id));
    }

    public Iterable<Event> getEvent() {
        return eventRepository.findAll();
    }

    public void deleteEvent(final Long id) {
        eventRepository.deleteById(id);
    }

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }
}