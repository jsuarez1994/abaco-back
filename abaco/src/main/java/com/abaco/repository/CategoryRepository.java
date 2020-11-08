package com.abaco.repository;

import java.util.List;
import java.util.Optional;

import com.abaco.entity.CategoryEntity;
import com.abaco.entity.UserEntity;

public interface CategoryRepository extends AbstractRepository<CategoryEntity> {

	Optional<CategoryEntity> findByDescriptionAndTypeAndNatureAndUser(final String description, final Integer type,
			final Integer nature, final UserEntity idUser);
	
	List<CategoryEntity> findAllByUser(UserEntity entity);

}
