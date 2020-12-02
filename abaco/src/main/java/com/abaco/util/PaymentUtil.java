package com.abaco.util;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.abaco.dto.PaymentDTO;

@Component
public class PaymentUtil {

	/**
	 * Sumamos todos los pagos, que sean gastos, a partir del tipo (fijo/personal)
	 * 
	 * @param payments
	 * @param type
	 * @return
	 */
	public Double getTotalExpensive(List<PaymentDTO> payments, Integer type) {
		List<PaymentDTO> list = payments.stream()
				.filter(payment -> payment.getCategory().getType().equals(type)
						&& payment.getCategory().getNature().equals(UtilConstants.NATURE_EXPENDITURES))
				.collect(Collectors.toList());

		return (CollectionUtils.isEmpty(list)) ? 0D : list.stream().mapToDouble(PaymentDTO::getQuantity).sum();
	}
	
	/**
	 * Sumamos todos los pagos, que sean gastos, a partir del tipo (fijo/personal) y periodo
	 * 
	 * @param payments
	 * @param type
	 * @return
	 */
	public Double getTotalExpensive(List<PaymentDTO> payments, Integer type, String period) {
		List<PaymentDTO> list = payments.stream()
				.filter(payment -> payment.getCategory().getType().equals(type)
						&& payment.getCategory().getNature().equals(UtilConstants.NATURE_EXPENDITURES)
						&& payment.getPeriod().equals(period))
				.collect(Collectors.toList());

		return (CollectionUtils.isEmpty(list)) ? 0D : list.stream().mapToDouble(PaymentDTO::getQuantity).sum();
	}

	/**
	 * Sumamos todos los pagos, que sean gastos
	 * 
	 * @param payments
	 * @return Double
	 */
	public Double getTotalExpensive(List<PaymentDTO> payments) {
		List<PaymentDTO> list = payments.stream()
				.filter(payment -> payment.getCategory().getNature().equals(UtilConstants.NATURE_EXPENDITURES))
				.collect(Collectors.toList());

		return (CollectionUtils.isEmpty(list)) ? 0D : list.stream().mapToDouble(PaymentDTO::getQuantity).sum();
	}
	
	/**
	 * Sumamos todos los pagos, que sean gastos a partir del periodo
	 * 
	 * @param payments
	 * @return Double
	 */
	public Double getTotalExpensive(List<PaymentDTO> payments, String period) {
		List<PaymentDTO> list = payments.stream()
				.filter(payment -> payment.getCategory().getNature().equals(UtilConstants.NATURE_EXPENDITURES)
						&& payment.getPeriod().equals(period))
				.collect(Collectors.toList());

		return (CollectionUtils.isEmpty(list)) ? 0D : list.stream().mapToDouble(PaymentDTO::getQuantity).sum();
	}

	/**
	 * Sumamos todos los pagos, que sean ganancias filtrado por periodo
	 * 
	 * @param payments
	 * @param period
	 * @return Double
	 */
	public Double getTotalGains(List<PaymentDTO> payments, String period) {
		List<PaymentDTO> list = payments.stream()
				.filter(payment -> payment.getCategory().getNature().equals(UtilConstants.NATURE_GAINS)
						&& StringUtils.equals(payment.getPeriod(), period))
				.collect(Collectors.toList());

		return (CollectionUtils.isEmpty(list)) ? 0D : list.stream().mapToDouble(PaymentDTO::getQuantity).sum();
	}
	
	/**
	 * Sumamos todos los pagos, que sean ganancias
	 * 
	 * @param payments
	 * @param type
	 * @return
	 */
	public Double getTotalGains(List<PaymentDTO> payments) {
		List<PaymentDTO> list = payments.stream()
				.filter(payment -> payment.getCategory().getNature().equals(UtilConstants.NATURE_GAINS))
				.collect(Collectors.toList());

		return (CollectionUtils.isEmpty(list)) ? 0D : list.stream().mapToDouble(PaymentDTO::getQuantity).sum();
	}
	
	/**
	 * Obtiene el numero de meses del anio filtrado por nature (gastos/ganacias)
	 * 
	 * @param payments
	 * @param type
	 * @return
	 */
	public Long getTotalMonthByNature(List<PaymentDTO> payments, Integer nature) {
		return payments.stream().filter(payment -> payment.getCategory().getNature().equals(nature)).count();
	}

	/**
	 * Sumamos todos los pagos, que sean ganancias
	 * 
	 * @param payments
	 * @param type
	 * @return
	 */
	public Double getPermitedToExpensive(List<PaymentDTO> payments, Integer porcentExpensive) {
		Double totalGains = getTotalGains(payments);

		Double result = totalGains * (porcentExpensive / 100);

		return (Double.isNaN(result)) ? 0D : result;

	}
	
	/**
	 * Obtenemos el porcentaje num1 * (num2/100)
	 * @param num1
	 * @param num2
	 * @return
	 */
	public Double porcentByFilter(Double num1, Double num2) {
		return num1 * (num2/100D);
	}

}
