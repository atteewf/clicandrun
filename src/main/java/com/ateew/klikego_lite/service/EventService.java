package com.ateew.klikego_lite.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ateew.klikego_lite.repository.EventRepository;
import com.ateew.klikego_lite.model.Event;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Optional<Event> getOneEvent(final long id) {
        return eventRepository.findById(id);
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