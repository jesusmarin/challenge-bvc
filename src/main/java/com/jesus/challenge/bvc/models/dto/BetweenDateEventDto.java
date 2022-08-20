package com.jesus.challenge.bvc.models.dto;

import com.jesus.challenge.bvc.models.entities.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BetweenDateEventDto extends BetweenDateDto{
    private Event event;
}
