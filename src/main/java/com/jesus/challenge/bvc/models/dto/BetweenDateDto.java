package com.jesus.challenge.bvc.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BetweenDateDto {
    private Long start;
    private Long end;
}
