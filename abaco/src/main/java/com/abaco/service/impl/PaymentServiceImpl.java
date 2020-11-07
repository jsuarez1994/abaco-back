package com.abaco.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.abaco.dto.PaymentDTO;
import com.abaco.entity.CategoryEntity;
import com.abaco.entity.PaymentEntity;
import com.abaco.entity.UserEntity;
import com.abaco.mapper.MapperUtils;
import com.abaco.mapper.PaymentMapper;
import com.abaco.repository.CategoryRepository;
import com.abaco.repository.PaymentRepository;
import com.abaco.service.PaymentService;
import com.abaco.util.LogUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	MapperUtils mapperUtils;

	@Autowired
	LogUtil logUtil;

	@Override
	public PaymentDTO save(PaymentDTO dto, Long idUser) {

		try {
			UserEntity userEntity = mapperUtils.mapperEntityById(idUser);

			PaymentEntity payment = PaymentMapper.INSTANCE.DTOtoEntity(dto);
			payment.setUser(userEntity);

			payment = paymentRepository.save(payment);

			Optional<CategoryEntity> category = categoryRepository.findByDescriptionAndTypeAndNatureAndUser(
					dto.getCategory().getDescription(), dto.getCategory().getType(), dto.getCategory().getNature(),
					userEntity);

			if (category.isPresent()) {

				category.get().setPayment(payment);
				category.get().setUser(userEntity);

				categoryRepository.save(category.get());

				return dto;

			} else {
				return null;
			}

		} catch (Exception e) {
			log.error(logUtil.errorMethod(this.getClass().getSimpleName(), "save", e.getMessage()));
			return null;
		}

	}

	@Override
	public List<PaymentDTO> getAllPaymentsByUser(Long idUser) {

		List<PaymentEntity> list = paymentRepository.findAllByUser(mapperUtils.mapperEntityById(idUser));

		if (!CollectionUtils.isEmpty(list)) {

			return list.stream().map(item -> PaymentMapper.INSTANCE.entityToDTO(item)).collect(Collectors.toList());

		} else {
			return new ArrayList<>();
		}

	}

}
