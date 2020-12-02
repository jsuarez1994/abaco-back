package com.abaco.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.abaco.dto.PaymentDTO;
import com.abaco.dto.UserDTO;
import com.abaco.internal.dto.DataStatisticsDTO;
import com.abaco.internal.dto.StatisticsObjectiveDTO;
import com.abaco.internal.dto.StatisticsRealDTO;
import com.abaco.internal.dto.StatisticsYearDTO;
import com.abaco.service.PaymentService;
import com.abaco.service.StatisticsService;
import com.abaco.service.UserService;
import com.abaco.util.PaymentUtil;
import com.abaco.util.UtilConstants;
import com.abaco.util.Utils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StatisticsServiceImpl extends BaseServiceImpl implements StatisticsService {

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private UserService userService;

	@Autowired
	private PaymentUtil paymentUtil;

	@Autowired
	private Utils utils;

	@Override
	public List<StatisticsYearDTO> getAllPeriods(Long idUser) {
		final String methodName = "getAllPeriods";
		log.info(logUtil.initMethod(this.getClass().getSimpleName(), methodName));

		List<StatisticsYearDTO> periodsPayments = new ArrayList<>();

		// Obtenemos todos los periodos que hay movimientos
		List<String> periods = paymentService.getAllPeriods(idUser);

		if (!CollectionUtils.isEmpty(periods)) {
			// Obtenemos los distintos anios
			List<String> years = periods.stream().map(period -> period.substring(0, 4)).distinct()
					.collect(Collectors.toList());

			// Guardamos los elementos por anio y todos los meses de ese anio
			years.stream().forEach(year -> {
				List<String> months = periods.stream().filter(period -> period.contains(year)).distinct()
						.map(period -> period.substring(4)).collect(Collectors.toList());

				periodsPayments.add(new StatisticsYearDTO(year, months));
			});

		}

		log.info(logUtil.finishMethod(this.getClass().getSimpleName(), methodName));

		return periodsPayments;
	}

	@Override
	public DataStatisticsDTO getDataByFilter(String year, Long idUser) {
		final String methodName = "getDataByFilter";
		log.info(logUtil.initMethod(this.getClass().getSimpleName(), methodName));

		DataStatisticsDTO dataStatistics = new DataStatisticsDTO();

		// Obtenemos los datos del usuario
		UserDTO user = userService.getUserById(idUser);

		if (ObjectUtils.isNotEmpty(user)) {

			// Obtenemos todos los pagos/ingresos por periodo
			List<PaymentDTO> payments = paymentService.getAllPaymentsByYear(year, idUser);

			// Obtener informacion Objetivo
			getStatisticsObjective(dataStatistics, payments, user);

			// Obtener informacion Real
			getStatisticsReal(dataStatistics, payments, user);
		}

		log.info(logUtil.finishMethod(this.getClass().getSimpleName(), methodName));
		return dataStatistics;
	}

	/**
	 * Obtenemos la informacion necesaria para mostrar en la tabla Objetivos
	 * 
	 * @param data
	 * @param period
	 * @param user
	 */
	private void getStatisticsObjective(DataStatisticsDTO data, List<PaymentDTO> payments, UserDTO user) {

		// Obtenemos la media de las ganacias (ganaciastotales/mesesconGanancias)
		Double avergeEntry = paymentUtil.getTotalGains(payments)
				/ paymentUtil.getTotalMonthByNature(payments, UtilConstants.NATURE_GAINS);

		// Obtenemos ahorro/mes
		Double saving = paymentUtil.porcentByFilter(avergeEntry, user.getPorcentSaving().doubleValue());

		// Obtenemos ahorro/anio
		Double objectiveAnualSaving = saving * 12D;

		// Obtenemos gasto personal
		Double personalExpensive = paymentUtil.porcentByFilter(avergeEntry,
				user.getPorcentPaymentPersonal().doubleValue());

		// Obtenemos gasto fijo
		Double permanentExpensive = paymentUtil.porcentByFilter(avergeEntry,
				user.getPorcentPaymentPermanent().doubleValue());

		data.setObjectiveDTO(new StatisticsObjectiveDTO(avergeEntry, saving, objectiveAnualSaving, personalExpensive,
				permanentExpensive));

	}

	/**
	 * Obtenemos la informacion necesaria para mostrar en la tabla Real
	 * 
	 * @param data
	 * @param period
	 * @param user
	 */
	private void getStatisticsReal(DataStatisticsDTO data, List<PaymentDTO> payments, UserDTO user) {

		List<StatisticsRealDTO> realsDTO = new ArrayList<>();

		List<String> periods = payments.stream().map(payment -> payment.getPeriod()).distinct()
				.collect(Collectors.toList());

		for (String period : periods) {
			// Obtenemos ganacias del periodo
			Double gains = paymentUtil.getTotalGains(payments, period);

			// Obtenemos la diferencia entre media ingreso y ganado
			Double excedentGain = gains - data.getObjectiveDTO().getAverageGains();

			// Obtenemos porcentaje hay que ahorrar
			Double objectSaving = paymentUtil.porcentByFilter(gains, user.getPorcentSaving().doubleValue());

			// Obtenemos el ahorro real
			Double realSaving = gains - paymentUtil.getTotalExpensive(payments, period);

			// Obtenemos el objetivo de gastos personales
			Double objectiveExpensivePersonal = paymentUtil.porcentByFilter(gains,
					user.getPorcentPaymentPersonal().doubleValue());

			// Obtenemos el gasto personal real
			Double realExpensivePersonal = paymentUtil.getTotalExpensive(payments, UtilConstants.TYPE_PERSONAL, period);

			// Obtenemos el objetivo de gastos fijos
			Double objectiveExpensivePermanent = paymentUtil.porcentByFilter(gains,
					user.getPorcentPaymentPermanent().doubleValue());

			// Obtenemos el gasto fijos real
			Double realExpensivePermanent = paymentUtil.getTotalExpensive(payments, UtilConstants.TYPE_PERMANENT,
					period);

			// Agregamos a la lista
			realsDTO.add(new StatisticsRealDTO(utils.getMonthByPeriod(period), gains, excedentGain, objectSaving,
					realSaving, objectiveExpensivePersonal, realExpensivePersonal, objectiveExpensivePermanent,
					realExpensivePermanent));

		}

		data.setRealDTO(realsDTO);

	}

}
