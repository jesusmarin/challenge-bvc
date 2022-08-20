package com.jesus.challenge.bvc.services;

import com.jesus.challenge.bvc.models.dto.EventDto;
import com.jesus.challenge.bvc.models.entities.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    EventDto getEventById(Long id);
    List<EventDto> findAll();
    EventDto addEvent(EventDto event);
    EventDto updateEvent(Event event);
    void removeEvent(Long id);

}
