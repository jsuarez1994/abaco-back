package com.abaco.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentDTO {

	private String description;

	private String period;

	private Float quantity;

	private CategoryDTO category;

}
