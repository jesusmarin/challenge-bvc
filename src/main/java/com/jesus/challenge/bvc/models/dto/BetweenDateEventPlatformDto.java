package com.jesus.challenge.bvc.models.dto;

import com.jesus.challenge.bvc.models.entities.Platform;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BetweenDateEventPlatformDto extends BetweenDateEventDto{
    private Platform platform;
}
