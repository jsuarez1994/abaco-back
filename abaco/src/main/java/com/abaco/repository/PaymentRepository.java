package com.abaco.repository;

import java.util.List;
import java.util.Optional;

import com.abaco.entity.CategoryEntity;
import com.abaco.entity.PaymentEntity;
import com.abaco.entity.UserEntity;

public interface PaymentRepository extends AbstractRepository<PaymentEntity> {

	/**
	 * Obtenemos el objeto a partir de Usuario asociado, descripcion y periodo
	 * 
	 * @param description
	 * @param period
	 * @param idUser
	 * @return
	 */
	Optional<PaymentEntity> findByDescriptionAndPeriodAndUser(final String description, final String period,
			final UserEntity idUser);

	/**
	 * Obtenemos todos los pagos de un usuario a partir del periodo
	 * 
	 * @param period
	 * @param user
	 * @return
	 */
	List<PaymentEntity> findAllByPeriodAndUser(final String period, final UserEntity user);

	/**
	 * Obtenemos todos los pagos de un usuario a partir del period y nature (tipo
	 * movimiento: ganacia/gasto)
	 * 
	 * @param period
	 * @param nature
	 * @param user
	 * @return
	 */
	List<PaymentEntity> findAllByPeriodAndCategoryAndUser(final String period, final CategoryEntity nature,
			final UserEntity user);
	
	/**
	 * Retorna todos los pagos de un usuario
	 * @param entity
	 * @return
	 */
	List<PaymentEntity> findAllByUser(UserEntity entity);

}
