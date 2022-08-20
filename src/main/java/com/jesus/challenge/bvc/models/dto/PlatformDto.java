package com.jesus.challenge.bvc.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlatformDto {
    private Long id;
    private String name;
    private String decription;
}
