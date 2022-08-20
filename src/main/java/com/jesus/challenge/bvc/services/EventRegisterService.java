package com.jesus.challenge.bvc.services;

import com.jesus.challenge.bvc.models.dto.EventRegisterDto;
import com.jesus.challenge.bvc.models.entities.Event;
import com.jesus.challenge.bvc.models.entities.EventRegister;
import com.jesus.challenge.bvc.models.entities.Platform;

import java.util.List;
import java.util.Optional;

public interface EventRegisterService {
    EventRegisterDto getEventRegisterById(Long id);
    List<EventRegisterDto> findAll();
    EventRegisterDto addEventRegister(EventRegisterDto dto);
    EventRegisterDto updateEventRegister(EventRegisterDto dto);
    void removeEventRegister(Long id);

    List<EventRegisterDto> findBetweenDate(Long startDate, Long endDate);
    List<EventRegisterDto> findBetweenDate(Long startDate, Long endDate, Event e);
    List<EventRegisterDto> findBetweenDate(Long startDate, Long endDate, Platform p);
    List<EventRegisterDto> findBetweenDate(Long startDate, Long endDate, Event e, Platform p);

    Integer countBetweenDate(Long startDate, Long endDate);
    Integer countBetweenDate(Long startDate, Long endDate, Event e);
    Integer countBetweenDate(Long startDate, Long endDate, Platform p);
    Integer countBetweenDate(Long startDate, Long endDate, Event e, Platform p);
}
