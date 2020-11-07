package com.abaco.service;

import java.util.List;

import com.abaco.dto.PaymentDTO;

public interface PaymentService {

	PaymentDTO save(PaymentDTO dto, Long idUser);

	List<PaymentDTO> getAllPaymentsByUser(Long idUser);
	
	int delete(PaymentDTO dto, Long idUser);

}
