package com.jesus.challenge.bvc.services;

import com.jesus.challenge.bvc.models.entities.Platform;

import java.util.List;
import java.util.Optional;

public interface PlatformService {
    Optional<Platform> getPlatformById(Long id);
    List<Platform> findAll();
    Platform addPlatform(Platform platform);
    Platform updatePlatform(Platform platform);
    void removePlatform(Long id);
}
