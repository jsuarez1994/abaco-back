package com.abaco.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.abaco.util.DataBaseConstants;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = DataBaseConstants.TABLE_USERS, schema = DataBaseConstants.SCHEMA)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 11412424L;

	@Column(name = "name")
	@NotNull
	@NotEmpty
	private String name;

	@Column(name = "surname")
	@NotNull
	@NotEmpty
	private String surname;

	@Column(name = "email", unique = true)
	@NotNull
	@NotEmpty
	@Email
	private String email;

	@Column(name = "password")
	@NotNull
	@NotEmpty
	private String password;

	@Column(name = "porcent_payment_personal")
	@Digits(integer = 2, fraction = 0)
	private Integer porcentPaymentPersonal;

	@Column(name = "porcent_payment_permanent")
	@Digits(integer = 2, fraction = 0)
	private Integer porcentPaymentPermanent;

	@Column(name = "porcent_saving")
	@Digits(integer = 2, fraction = 0)
	private Integer porcentSaving;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PaymentEntity> payments;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CategoryEntity> categories;

}
