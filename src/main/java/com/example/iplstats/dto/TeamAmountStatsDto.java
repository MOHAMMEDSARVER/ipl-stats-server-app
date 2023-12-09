package com.example.iplstats.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamAmountStatsDto {
        private String teamName;
        private BigDecimal totalAmount;
}
