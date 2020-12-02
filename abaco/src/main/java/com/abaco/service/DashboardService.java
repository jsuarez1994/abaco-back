package com.abaco.service;

import com.abaco.internal.dto.DataDashboardDTO;
import com.abaco.internal.dto.FilterDTO;

public interface DashboardService {

	/**
	 * Retorna los datos de la vista principal
	 * @param filter
	 * @return DataDashboardDTO
	 */
	DataDashboardDTO getDataByFilter(FilterDTO filter);

}
