package com.jesus.challenge.bvc.models.dto;

import com.jesus.challenge.bvc.models.entities.Event;
import com.jesus.challenge.bvc.models.entities.Platform;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BetweenDateEventPlatformDto{
    private Long start;
    private Long end;
    private Event event;
    private Platform platform;
}
