package com.jesus.challenge.bvc.services;

import com.jesus.challenge.bvc.models.dto.BetweenDateEventPlatformDto;
import com.jesus.challenge.bvc.models.dto.EventRegisterDto;

import java.util.List;

public interface FilterEventRegister {
    List<EventRegisterDto> findBetweenDate(BetweenDateEventPlatformDto dto);
    Integer countBetweenDate(BetweenDateEventPlatformDto dto);
}
