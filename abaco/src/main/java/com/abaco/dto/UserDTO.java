package com.abaco.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

	private String name;

	private String surname;

	private String email;

	private String password;

	private Integer porcentPaymentPersonal;

	private Integer porcentPaymentPermanent;

	private Integer porcentSaving;

}
