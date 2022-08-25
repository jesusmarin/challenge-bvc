package com.jesus.challenge.bvc.services;

import com.jesus.challenge.bvc.models.dto.EventRegisterDto;
import com.jesus.challenge.bvc.models.entities.Event;
import com.jesus.challenge.bvc.models.entities.Platform;

import java.util.List;
import java.util.Optional;

public interface EventRegisterService {
    EventRegisterDto getEventRegisterById(Long id);
    List<EventRegisterDto> findAll();
    EventRegisterDto addEventRegister(EventRegisterDto dto);
    EventRegisterDto updateEventRegister(EventRegisterDto dto);
    void removeEventRegister(Long id);

}
