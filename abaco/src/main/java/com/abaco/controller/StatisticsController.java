package com.abaco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abaco.internal.dto.DataStatisticsDTO;
import com.abaco.internal.dto.StatisticsYearDTO;
import com.abaco.service.StatisticsService;
import com.abaco.util.EndPointsConstants;
import com.abaco.util.SwaggerConstants;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(EndPointsConstants.EP_STATISTICS_CONTROLLER)
@Slf4j
public class StatisticsController extends BaseController {
	
	@Autowired
	private StatisticsService statisticsService;

	/**
	 * Obtenemos la informacion necesaria para estadisticas
	 * 
	 * @param period
	 * @return DataStatisticsDTO
	 */
	@ApiOperation(value = SwaggerConstants.AO_STATISTICSCONTROLLER_GETDATABYFILTER)
	@GetMapping(path = EndPointsConstants.EP_STATISTICS_CONTROLLER_GETDATABYFILTER, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getDataByFilter(@RequestParam String year) {

		final String methodName = "getDataByFilter";

		log.info(logUtil.initMethod(this.getClass().getSimpleName(), methodName));

		try {
			// TODO: Obtener usuario logado
			Long idUser = 2L;
			DataStatisticsDTO dataStatistics = statisticsService.getDataByFilter(year, idUser);
			
			log.info(logUtil.finishMethod(this.getClass().getSimpleName(), methodName));
			
			return ResponseEntity.ok(dataStatistics);

		} catch (Exception e) {
			log.error(logUtil.errorMethod(this.getClass().getSimpleName(), methodName, e.getMessage()));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}

	}
	
	/**
	 * Obtenemos todos los periodos por los que podemos filtrar
	 * @return StatisticsYearDTO
	 */
	@ApiOperation(value = SwaggerConstants.AO_STATISTICSCONTROLLER_GETALLPERIODS)
	@GetMapping(path = EndPointsConstants.EP_STATISTICS_CONTROLLER_GETALLPERIODS, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getAllPeriods() {

		final String methodName = "getAllPeriods";

		log.info(logUtil.initMethod(this.getClass().getSimpleName(), methodName));

		try {
			// TODO: Obtener usuario logado
			Long idUser = 2L; 
			
			List<StatisticsYearDTO> periods = statisticsService.getAllPeriods(idUser);
			
			log.info(logUtil.finishMethod(this.getClass().getSimpleName(), methodName));
			
			return ResponseEntity.ok(periods);

		} catch (Exception e) {
			log.error(logUtil.errorMethod(this.getClass().getSimpleName(), methodName, e.getMessage()));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}

	}

}
