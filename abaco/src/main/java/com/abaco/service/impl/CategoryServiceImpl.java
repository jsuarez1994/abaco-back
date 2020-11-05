package com.abaco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abaco.dto.CategoryDTO;
import com.abaco.entity.CategoryEntity;
import com.abaco.entity.UserEntity;
import com.abaco.internal.validation.CategoryValidation;
import com.abaco.mapper.CategoryMapper;
import com.abaco.repository.AbstractRepository;
import com.abaco.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	AbstractRepository<CategoryEntity> abstractRepository;

	@Autowired
	CategoryValidation categoryValidation;

	@Override
	public CategoryDTO save(CategoryDTO dto) {

		// TODO: Recoger usuario logado
		UserEntity userEntity = new UserEntity();
		userEntity.setId(5L);

		if (categoryValidation.validToSave(dto, userEntity)) {
			CategoryEntity entity = CategoryMapper.INSTANCE.DTOtoEntity(dto);
			return CategoryMapper.INSTANCE.entityToDTO(abstractRepository.save(entity));
		} else {
			return null;
		}

	}

}
