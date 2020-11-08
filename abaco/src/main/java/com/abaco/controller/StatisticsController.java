package com.abaco.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abaco.util.EndPointsConstants;
import com.abaco.util.SwaggerConstants;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(EndPointsConstants.EP_STATISTICS_CONTROLLER)
@Slf4j
public class StatisticsController extends BaseController {

	/**
	 * Obtenemos la informacion necesaria para estadisticas
	 * 
	 * @param filter
	 * @return DataDashboardDTO
	 */
	@ApiOperation(value = SwaggerConstants.AO_STATISTICSCONTROLLER_GETDATABYFILTER)
	@PostMapping(path = EndPointsConstants.EP_STATISTICS_CONTROLLER_GETDATABYFILTER, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getDataByFilter(@RequestParam String period) {

		final String methodName = "getDataByFilter";

		log.info(logUtil.initMethod(this.getClass().getSimpleName(), methodName));

		try {

			// TODO
			
			return ResponseEntity.ok(null);

		} catch (Exception e) {
			log.error(logUtil.errorMethod(this.getClass().getSimpleName(), methodName, e.getMessage()));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}

	}

}
