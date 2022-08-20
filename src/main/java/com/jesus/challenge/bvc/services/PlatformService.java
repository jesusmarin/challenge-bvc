package com.jesus.challenge.bvc.services;

import com.jesus.challenge.bvc.models.dto.PlatformDto;
import com.jesus.challenge.bvc.models.entities.Platform;

import java.util.List;
import java.util.Optional;

public interface PlatformService {
    PlatformDto getPlatformById(Long id);
    List<PlatformDto> findAll();
    PlatformDto addPlatform(PlatformDto dto);
    PlatformDto updatePlatform(PlatformDto dto);
    void removePlatform(Long id);
}
