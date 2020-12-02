package com.abaco.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.abaco.dto.PaymentDTO;
import com.abaco.entity.CategoryEntity;
import com.abaco.entity.PaymentEntity;
import com.abaco.entity.UserEntity;
import com.abaco.mapper.PaymentMapper;
import com.abaco.repository.CategoryRepository;
import com.abaco.repository.PaymentRepository;
import com.abaco.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentServiceImpl extends BaseServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public PaymentDTO save(PaymentDTO dto, Long idUser) {

		try {
			UserEntity userEntity = mapperUtils.mapperEntityById(idUser);

			// Comprobamos si existe la categoria asociada
			Optional<CategoryEntity> category = categoryRepository.findByDescriptionAndTypeAndNatureAndUser(
					dto.getCategory().getDescription(), dto.getCategory().getType(), dto.getCategory().getNature(),
					userEntity);

			if (category.isPresent()) {

				PaymentEntity payment = PaymentMapper.INSTANCE.DTOtoEntity(dto);
				payment.setUser(userEntity);

				// Verificamos si existe el objeto en BD
				Optional<PaymentEntity> itemBD = paymentRepository.findByDescriptionAndPeriodAndUser(
						StringUtils.trimToNull(dto.getDescription()), StringUtils.trimToNull(dto.getPeriod()),
						userEntity);

				// Si existe seteamos el ID para actualizarlo
				if (itemBD.isPresent()) {
					payment.setId(itemBD.get().getId());
				}

				// Guardamos Pago
				payment = paymentRepository.save(payment);

				// La categoria previamente verificada la guardamos con los parametros obtenidos
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
	public List<PaymentDTO> getAllItemsByUser(Long idUser) {

		List<PaymentEntity> list = paymentRepository.findAllByUser(mapperUtils.mapperEntityById(idUser));

		return (!CollectionUtils.isEmpty(list)) ? PaymentMapper.INSTANCE.listEntityToDTO(list) : new ArrayList<>();

	}

	@Override
	public int delete(PaymentDTO dto, Long idUser) {

		try {
			Optional<PaymentEntity> payment = paymentRepository.findByDescriptionAndPeriodAndUser(
					StringUtils.trimToNull(dto.getDescription()), StringUtils.trimToNull(dto.getPeriod()),
					mapperUtils.mapperEntityById(idUser));

			if (payment.isPresent()) {
				paymentRepository.delete(payment.get());
				return 1;
			} else {
				return 0;
			}

		} catch (Exception e) {
			log.error(logUtil.errorMethod(this.getClass().getSimpleName(), "delete", e.getMessage()));
			return 0;
		}

	}

	@Override
	public List<PaymentDTO> getAllPaymentsByPeriod(String period, Long idUser) {

		try {

			List<PaymentEntity> list = paymentRepository.findAllByPeriodAndUser(period,
					mapperUtils.mapperEntityById(idUser));

			return (!CollectionUtils.isEmpty(list)) ? PaymentMapper.INSTANCE.listEntityToDTO(list) : new ArrayList<>();

		} catch (Exception e) {
			log.error(logUtil.errorMethod(this.getClass().getSimpleName(), "getAllPaymentsByPeriod", e.getMessage()));
			return null;
		}
	}

	@Override
	public List<PaymentDTO> getAllPaymentsByPeriodAndNature(String period, Integer nature, Long idUser) {

		try {

			CategoryEntity catByNature = new CategoryEntity();
			catByNature.setNature(nature);

			List<PaymentEntity> list = paymentRepository.findAllByPeriodAndCategoryAndUser(period, catByNature,
					mapperUtils.mapperEntityById(idUser));

			return (!CollectionUtils.isEmpty(list)) ? PaymentMapper.INSTANCE.listEntityToDTO(list) : new ArrayList<>();

		} catch (Exception e) {
			log.error(logUtil.errorMethod(this.getClass().getSimpleName(), "getAllPaymentsByPeriod", e.getMessage()));
			return null;
		}
	}

	@Override
	public List<String> getAllPeriods(Long idUser) {

		List<String> periods = paymentRepository.findAllPeriodsByUser(idUser);

		return (CollectionUtils.isEmpty(periods)) ? new ArrayList<>()
				: periods.stream().distinct().collect(Collectors.toList());
	}

	@Override
	public List<PaymentDTO> getAllPaymentsByYear(String year, Long idUser) {

		try {

			List<PaymentEntity> list = paymentRepository.findAllByPeriodStartsWithAndUser(year, mapperUtils.mapperEntityById(idUser));

			return (!CollectionUtils.isEmpty(list)) ? PaymentMapper.INSTANCE.listEntityToDTO(list) : new ArrayList<>();

		} catch (Exception e) {
			log.error(logUtil.errorMethod(this.getClass().getSimpleName(), "getAllPaymentsByPeriod", e.getMessage()));
			return null;
		}
	}

}
