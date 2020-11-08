package com.abaco.internal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProgressReportDTO {

	private Double totalExpensivePersonal;

	private Double totalExpensivePermanent;

	private Double totalGains;

	private String permitedExpensivePersonal;

	private String permitedExpensivePermanent;

}
