package com.abaco.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.abaco.dto.PaymentDTO;
import com.abaco.entity.PaymentEntity;

@Mapper(componentModel = "spring")
public interface PaymentMapper extends AbstractMapper<PaymentEntity, PaymentDTO> {

	PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

}
