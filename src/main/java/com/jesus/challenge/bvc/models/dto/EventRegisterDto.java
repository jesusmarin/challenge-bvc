package com.jesus.challenge.bvc.models.dto;

import com.jesus.challenge.bvc.models.entities.Event;
import com.jesus.challenge.bvc.models.entities.Platform;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventRegisterDto {
    private Long id;
    private Platform platform;
    private Event event;
}
