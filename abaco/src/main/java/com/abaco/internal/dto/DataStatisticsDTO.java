package com.abaco.internal.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DataStatisticsDTO {
	
	private List<StatisticsYearDTO> yearsOfPayments;

	private StatisticsObjectiveDTO objectiveDTO;

	private StatisticsRealDTO realDTO;

}
