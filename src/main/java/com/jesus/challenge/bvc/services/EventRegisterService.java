package com.jesus.challenge.bvc.services;

import com.jesus.challenge.bvc.models.entities.Event;
import com.jesus.challenge.bvc.models.entities.EventRegister;
import com.jesus.challenge.bvc.models.entities.Platform;

import java.util.List;
import java.util.Optional;

public interface EventRegisterService {
    Optional<EventRegister> getEventRegisterById(Long id);
    List<EventRegister> findAll();
    EventRegister addEventRegister(EventRegister platform);
    EventRegister updateEventRegister(EventRegister platform);
    void removeEventRegister(Long id);

    List<EventRegister> findBetweenDate(Long startDate, Long endDate);
    List<EventRegister> findBetweenDate(Long startDate, Long endDate, Event e);
    List<EventRegister> findBetweenDate(Long startDate, Long endDate, Event e, Platform p);

    Integer countBetweenDate(Long startDate, Long endDate);
    Integer countBetweenDate(Long startDate, Long endDate, Event e);
    Integer countBetweenDate(Long startDate, Long endDate, Platform p);
}
