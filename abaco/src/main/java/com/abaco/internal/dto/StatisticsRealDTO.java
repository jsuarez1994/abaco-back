package com.abaco.internal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StatisticsRealDTO {

	private String period;

	private Double gain;

	private Double excedentGain;

	private Double objectSaving;

	private Double realSaving;

	private Double objectiveExpensivePersonal;

	private Double realExpensivePersonal;

	private Double objectiveExpensivePermanent;

	private Double realExpensivePermanent;

}
