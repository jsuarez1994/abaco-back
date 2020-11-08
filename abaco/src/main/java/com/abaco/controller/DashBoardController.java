package com.abaco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abaco.internal.dto.DataDashboardDTO;
import com.abaco.internal.dto.FilterDTO;
import com.abaco.service.DashboardService;
import com.abaco.util.EndPointsConstants;
import com.abaco.util.SwaggerConstants;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(EndPointsConstants.EP_DASHBOARD_CONTROLLER)
@Slf4j
public class DashBoardController extends BaseController {

	@Autowired
	private DashboardService dashboardService;

	/**
	 * Obtenemos la informacion necesaria para dashboard
	 * 
	 * @param filter
	 * @return DataDashboardDTO
	 */
	@ApiOperation(value = SwaggerConstants.AO_DASHBOARDCONTROLLER_GETDATABYFILTER)
	@PostMapping(path = EndPointsConstants.EP_PAYMENT_CONTROLLER_GETDATABYFILTER, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getDataByFilter(@RequestBody FilterDTO filter) {

		final String methodName = "getDataByFilter";

		log.info(logUtil.initMethod(this.getClass().getSimpleName(), methodName));

		try {

			DataDashboardDTO data = dashboardService.getDataByFilter(filter);

			return ResponseEntity.ok(data);

		} catch (Exception e) {
			log.error(logUtil.errorMethod(this.getClass().getSimpleName(), methodName, e.getMessage()));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}

	}

}
