package com.abaco.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.abaco.util.DataBaseConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = DataBaseConstants.TABLE_CATEGORIES, schema = DataBaseConstants.SCHEMA)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "description")
	@NotNull
	@NotEmpty
	private String description;

	@Column(name = "type", length = 6)
	@NotNull
	@NotEmpty
	@Min(value = 0)
	@Max(value = 1)
	private Integer type;

	@Column(name = "nature")
	@NotNull
	@NotEmpty
	@Min(value = 0)
	@Max(value = 1)
	private Integer nature;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_payment")
	private PaymentEntity payment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user")
	@JsonIgnore
	private UserEntity user;

}
