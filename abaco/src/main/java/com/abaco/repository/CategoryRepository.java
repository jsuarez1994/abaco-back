package com.abaco.repository;

import com.abaco.entity.CategoryEntity;
import com.abaco.entity.UserEntity;

public interface CategoryRepository extends AbstractRepository<CategoryEntity> {

	CategoryEntity findByDescriptionAndTypeAndNatureAndUser(final String description, final Integer type,
			final Integer nature, final UserEntity idUser);

}
