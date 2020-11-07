package com.abaco.repository;

import java.util.List;

import com.abaco.entity.PaymentEntity;
import com.abaco.entity.UserEntity;

public interface PaymentRepository extends AbstractRepository<PaymentEntity> {

	List<PaymentEntity> findAllByUser(UserEntity entity);

}
