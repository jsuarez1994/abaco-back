package com.abaco.service;

import java.util.List;

import com.abaco.internal.dto.DataStatisticsDTO;
import com.abaco.internal.dto.StatisticsYearDTO;

public interface StatisticsService {

	/**
	 * Retorna todos los anios y meses del ese mismo anio que tiene pagos a partir
	 * del usuario
	 * 
	 * @param idUser
	 * @return List<StatisticsYearDTO>
	 */
	List<StatisticsYearDTO> getAllPeriods(Long idUser);

	/**
	 * Retorna los datos para vista
	 * 
	 * @param period
	 * @param idUser
	 * @return DataStatisticsDTO
	 */
	DataStatisticsDTO getDataByFilter(String period, Long idUser);

}
