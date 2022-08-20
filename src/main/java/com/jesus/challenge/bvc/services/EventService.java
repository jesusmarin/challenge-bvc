package com.jesus.challenge.bvc.services;

import com.jesus.challenge.bvc.models.entities.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    Optional<Event> getEventById(Long id);
    List<Event> findAll();
    Event addEvent(Event event);
    Event updateEvent(Event event);
    void removeEvent(Long id);

}
