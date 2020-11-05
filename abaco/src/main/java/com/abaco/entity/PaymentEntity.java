package com.abaco.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.abaco.util.DataBaseConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = DataBaseConstants.TABLE_PAYMENTS, schema = DataBaseConstants.SCHEMA)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "description")
	private String description;

	@Column(name = "period", length = 6)
	@NotNull
	@NotEmpty
	private String period;

	@Column(name = "quantity")
	@NotNull
	@NotEmpty
	private Float quantity;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "payment")
	private CategoryEntity category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user")
	@JsonIgnore
	private UserEntity user;

}
