package com.abaco.service;

import java.util.List;

import com.abaco.dto.PaymentDTO;

public interface PaymentService extends AbstractService<PaymentDTO> {

	/**
	 * Obtiene todos los pagos de un usuario a partir del periodo
	 * 
	 * @param period
	 * @param idUser
	 * @return List<PaymentDTO>
	 */
	List<PaymentDTO> getAllPaymentsByPeriod(String period, Long idUser);
	
	/**
	 * Obtiene todos los pagos de un usuario a partir del periodo
	 * 
	 * @param period
	 * @param idUser
	 * @return List<PaymentDTO>
	 */
	List<PaymentDTO> getAllPaymentsByYear(String year, Long idUser);

	/**
	 * Obtiene todos los pagos de un usuario a partir del periodo y nature(tipo
	 * movimiento: ganancia/gasto)
	 * 
	 * @param period
	 * @param idUser
	 * @return List<PaymentDTO>
	 */
	List<PaymentDTO> getAllPaymentsByPeriodAndNature(String period, Integer nature, Long idUser);
	
	/**
	 * Obtiene todos los periodos en los que se ha hecho pago
	 * 
	 * @param idUser
	 * @return List<String>
	 */
	List<String> getAllPeriods(Long idUser);

}
