package com.jesus.challenge.bvc.models.dto;

import com.jesus.challenge.bvc.models.entities.Platform;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {

    private Long id;
    private String idEvent;
    private String description;
    private BigDecimal cost;

}
