package com.abaco.internal.dto;

import java.util.List;

import com.abaco.dto.CategoryDTO;
import com.abaco.dto.PaymentDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DataDashboardDTO {

	List<PaymentDTO> listPayment;

	List<CategoryDTO> listCategory;

	ProgressReportDTO progressReport;
}
