package com.abaco.util;

import java.util.List;
import java.util.stream.Collectors;

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
	 * Sumamos todos los pagos, que sean gastos, a partir del tipo (fijo/personal)
	 * 
	 * @param payments
	 * @param type
	 * @return
	 */
	public Double getTotalExpensive(List<PaymentDTO> payments) {
		List<PaymentDTO> list = payments.stream()
				.filter(payment -> payment.getCategory().getNature().equals(UtilConstants.NATURE_EXPENDITURES))
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

		return (CollectionUtils.isEmpty(list)) ? 
				0D : 
					list.stream().mapToDouble(PaymentDTO::getQuantity).sum();

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

}
