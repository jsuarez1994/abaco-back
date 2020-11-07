package com.abaco.internal.validation;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abaco.dto.UserDTO;
import com.abaco.internal.object.PorcentsDefault;

@Component
public class UserValidation {

	@Autowired
	PorcentsDefault procentDefault;

	/**
	 * Validamos los porcentajes asociados al usuario para ese usuario
	 * 
	 * @param dto
	 * @param idUser
	 * @return
	 */
	public boolean validatePorcent(UserDTO user) {

		Integer permanent = ObjectUtils.isNotEmpty(user.getPorcentPaymentPermanent())
				? user.getPorcentPaymentPermanent()
				: procentDefault.getPermanent();

		Integer personal = ObjectUtils.isNotEmpty(user.getPorcentPaymentPersonal()) ? user.getPorcentPaymentPersonal()
				: procentDefault.getPersonal();

		Integer saving = ObjectUtils.isNotEmpty(user.getPorcentSaving()) ? user.getPorcentSaving()
				: procentDefault.getSaving();

		// validamos que la suma de los porcentajes no sea > 100 y que Permanent no sea
		// mayor que 50, personal > 30 y saving < 20
		return (permanent + personal + saving <= 100) && ((permanent <= 50) && (personal <= 30) && (saving >= 20));

	}

}
