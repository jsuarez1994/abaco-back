package com.abaco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abaco.dto.PaymentDTO;
import com.abaco.service.PaymentService;
import com.abaco.util.EndPointsConstants;
import com.abaco.util.LogUtil;
import com.abaco.util.SwaggerConstants;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(EndPointsConstants.EP_PAYMENT_CONTROLLER)
@Slf4j
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@Autowired
	LogUtil logUtil;

	/**
	 * Guardar elemento Usuario
	 * 
	 * @param user
	 * @return UserDTO
	 */
	@ApiOperation(value = SwaggerConstants.AO_USERCONTROLLER_SAVE)
	@PostMapping(path = EndPointsConstants.EP_PAYMENT_CONTROLLER_SAVE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@RequestBody PaymentDTO dto) {

		final String methodName = "save";

		log.info(logUtil.initMethod(this.getClass().getSimpleName(), methodName));
		try {

			// TODO: OBTENER ID DE USUARIO LOGADO
			Long id = 2L;

			PaymentDTO saved = paymentService.save(dto, id);
			log.info(logUtil.finishMethod(this.getClass().getSimpleName(), methodName));
			return ResponseEntity.ok(saved);
		} catch (Exception e) {
			log.error(logUtil.errorMethod(this.getClass().getSimpleName(), methodName, e.getMessage()));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	/**
	 * Retorna todos los pagos por usuario
	 * 
	 * @return List<PaymentDTO>
	 */
	@ApiOperation(value = SwaggerConstants.AO_PAYMENTCONTROLLER_GETALLBYUSER)
	@PostMapping(path = EndPointsConstants.EP_PAYMENT_CONTROLLER_GETALLBYUSER, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getAllByUser() {

		final String methodName = "getAllByUser";

		log.info(logUtil.initMethod(this.getClass().getSimpleName(), methodName));
		try {

			// TODO: OBTENER ID DE USUARIO LOGADO
			Long id = 2L;

			List<PaymentDTO> payments = paymentService.getAllPaymentsByUser(id);
			log.info(logUtil.finishMethod(this.getClass().getSimpleName(), methodName));
			return ResponseEntity.ok(payments);

		} catch (Exception e) {
			log.error(logUtil.errorMethod(this.getClass().getSimpleName(), methodName, e.getMessage()));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	/**
	 * Elimina payment
	 * 
	 * @return List<PaymentDTO>
	 */
	@ApiOperation(value = SwaggerConstants.AO_PAYMENTCONTROLLER_DELETE)
	@PostMapping(path = EndPointsConstants.EP_PAYMENT_CONTROLLER_DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> delete(@RequestBody PaymentDTO dto) {

		final String methodName = "delete";

		log.info(logUtil.initMethod(this.getClass().getSimpleName(), methodName));
		try {

			// TODO: OBTENER ID DE USUARIO LOGADO
			Long id = 2L;

			int register = paymentService.delete(dto, id);
			log.info(logUtil.finishMethod(this.getClass().getSimpleName(), methodName));
			return ResponseEntity.ok((register == 0) ? Boolean.FALSE : Boolean.TRUE);

		} catch (Exception e) {
			log.error(logUtil.errorMethod(this.getClass().getSimpleName(), methodName, e.getMessage()));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
