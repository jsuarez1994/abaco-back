package com.abaco.repository;

import java.util.List;
import java.util.Optional;

import com.abaco.entity.PaymentEntity;
import com.abaco.entity.UserEntity;

public interface PaymentRepository extends AbstractRepository<PaymentEntity> {

	Optional<PaymentEntity> findByDescriptionAndPeriodAndUser(final String description, final String period,
			final UserEntity idUser);

	List<PaymentEntity> findAllByUser(UserEntity entity);

}
