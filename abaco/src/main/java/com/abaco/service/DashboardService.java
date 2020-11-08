package com.abaco.service;

import com.abaco.internal.dto.DataDashboardDTO;
import com.abaco.internal.dto.FilterDTO;

public interface DashboardService {

	DataDashboardDTO getDataByFilter(FilterDTO filter);

}
