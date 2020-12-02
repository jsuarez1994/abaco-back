package com.abaco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abaco.entity.UserEntity;
import com.abaco.internal.dto.DataDashboardDTO;
import com.abaco.internal.dto.FilterDTO;
import com.abaco.internal.dto.ProgressReportDTO;
import com.abaco.service.CategoryService;
import com.abaco.service.DashboardService;
import com.abaco.service.PaymentService;
import com.abaco.util.PaymentUtil;
import com.abaco.util.UtilConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DashboardServiceImpl extends BaseServiceImpl implements DashboardService {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private PaymentUtil paymentUtil;

	@Override
	public DataDashboardDTO getDataByFilter(FilterDTO filter) {

		final String methodName = "getDataByFilter";

		log.info(logUtil.initMethod(this.getClass().getSimpleName(), methodName));

		DataDashboardDTO dataDashboard = new DataDashboardDTO();

		// TODO: OBTENER ID DE USUARIO LOGADO
		UserEntity userEntity = mapperUtils.mapperEntityById(2L);
		userEntity.setPorcentPaymentPersonal(30);
		userEntity.setPorcentPaymentPermanent(50);

		// Obtenemos todas las categorias
		dataDashboard.setListCategory(categoryService.getAllItemsByUser(userEntity.getId()));

		// Obtenemos todos los pagos a partir de filtro. Si no se ha enviado nature
		dataDashboard.setListPayment((filter.getMoveType().equals(new Integer(-1)))
				? paymentService.getAllPaymentsByPeriod(filter.getPeriod(), userEntity.getId())
				: paymentService.getAllPaymentsByPeriodAndNature(filter.getPeriod(), filter.getMoveType(),
						userEntity.getId()));

		// Obtenemos total ganancias
		ProgressReportDTO progressReport = new ProgressReportDTO();
		progressReport.setTotalGains(paymentUtil.getTotalGains(dataDashboard.getListPayment()));

		// Obtenemos total gastos fijos
		progressReport.setTotalExpensivePermanent(
				paymentUtil.getTotalExpensive(dataDashboard.getListPayment(), UtilConstants.TYPE_PERMANENT));

		// Obtenemos total gastos personal
		progressReport.setTotalExpensivePersonal(
				paymentUtil.getTotalExpensive(dataDashboard.getListPayment(), UtilConstants.TYPE_PERSONAL));

		// Obtenemos los gastos que nos podemos permitir de Personal
		Double permitedExpensivePersonal = paymentUtil.getPermitedToExpensive(dataDashboard.getListPayment(),
				userEntity.getPorcentPaymentPersonal());
		progressReport.setPermitedExpensivePersonal(permitedExpensivePersonal.toString().concat(UtilConstants.PORCENT));

		// Obtenemos los gastos que nos podemos permitir Fijo
		Double permitedExpensivePermanent = paymentUtil.getPermitedToExpensive(dataDashboard.getListPayment(),
				userEntity.getPorcentPaymentPermanent());
		progressReport
				.setPermitedExpensivePermanent(permitedExpensivePermanent.toString().concat(UtilConstants.PORCENT));

		dataDashboard.setProgressReport(progressReport);

		log.info(logUtil.finishMethod(this.getClass().getSimpleName(), methodName));

		return dataDashboard;
	}

}
