package com.abaco.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
public class UserDTO {

	String name;

	String surname;

	String email;

	String password;

	Integer porcentPaymentPersonal;

	Integer porcentPaymentPermanent;

	Integer porcentSaving;

}
