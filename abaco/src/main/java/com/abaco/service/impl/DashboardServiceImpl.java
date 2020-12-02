package com.abaco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
		Double totalGains = (!CollectionUtils.isEmpty(dataDashboard.getListPayment()))
				? paymentUtil.getTotalGains(dataDashboard.getListPayment())
				: UtilConstants.CERO_D;
		progressReport.setTotalGains(totalGains);

		// Obtenemos total gastos fijos
		Double totalExpensivePermanent = (!CollectionUtils.isEmpty(dataDashboard.getListPayment()))
				? paymentUtil.getTotalExpensive(dataDashboard.getListPayment(), UtilConstants.TYPE_PERMANENT)
				: UtilConstants.CERO_D;
		progressReport.setTotalExpensivePermanent(totalExpensivePermanent);

		// Obtenemos total gastos personal
		Double totalExpensivePersonal = (!CollectionUtils.isEmpty(dataDashboard.getListPayment()))
				? paymentUtil.getTotalExpensive(dataDashboard.getListPayment(), UtilConstants.TYPE_PERSONAL)
				: UtilConstants.CERO_D;
		progressReport.setTotalExpensivePersonal(totalExpensivePersonal);

		// Obtenemos los gastos que nos podemos permitir de Personal
		Double permitedExpensivePersonal = (!CollectionUtils.isEmpty(dataDashboard.getListPayment())) ? paymentUtil
				.getPermitedToExpensive(dataDashboard.getListPayment(), userEntity.getPorcentPaymentPersonal())
				: UtilConstants.CERO_D;
		progressReport.setPermitedExpensivePersonal(permitedExpensivePersonal.toString().concat(UtilConstants.PORCENT));

		// Obtenemos los gastos que nos podemos permitir Fijo
		Double permitedExpensivePermanent = (!CollectionUtils.isEmpty(dataDashboard.getListPayment())) ? paymentUtil
				.getPermitedToExpensive(dataDashboard.getListPayment(), userEntity.getPorcentPaymentPermanent())
				: UtilConstants.CERO_D;
		progressReport
				.setPermitedExpensivePermanent(permitedExpensivePermanent.toString().concat(UtilConstants.PORCENT));

		dataDashboard.setProgressReport(progressReport);

		log.info(logUtil.finishMethod(this.getClass().getSimpleName(), methodName));

		return dataDashboard;
	}

}
