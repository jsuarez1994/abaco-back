package com.abaco.internal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StatisticsObjectiveDTO {

	/** Ingreso medio anual */
	private Double averageGains;

	/** Ahorro (segun porcentaje usuario) */
	private Double savings;

	/** Objetivo Ahorro anual */
	private Double objectiveAnnualSavings;

	/** Gastos personales */
	private Double expensivePersonal;

	/** Gastos fijo */
	private Double expensivePermanent;

}
