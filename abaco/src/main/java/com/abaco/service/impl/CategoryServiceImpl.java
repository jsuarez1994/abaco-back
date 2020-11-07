package com.abaco.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.abaco.dto.CategoryDTO;
import com.abaco.entity.CategoryEntity;
import com.abaco.entity.UserEntity;
import com.abaco.internal.validation.CategoryValidation;
import com.abaco.mapper.CategoryMapper;
import com.abaco.mapper.MapperUtils;
import com.abaco.repository.CategoryRepository;
import com.abaco.service.CategoryService;
import com.abaco.util.LogUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	CategoryValidation categoryValidation;

	@Autowired
	MapperUtils mapperUtils;

	@Autowired
	LogUtil logUtil;

	@Override
	public CategoryDTO save(CategoryDTO dto, Long idUser) {

		try {
			UserEntity userEntity = mapperUtils.mapperEntityById(idUser);

			if (categoryValidation.validToSave(dto, userEntity)) {
				CategoryEntity entity = CategoryMapper.INSTANCE.DTOtoEntity(dto);
				entity.setUser(userEntity);
				return CategoryMapper.INSTANCE.entityToDTO(categoryRepository.save(entity));
			} else {
				return null;
			}

		} catch (Exception e) {
			log.error(logUtil.errorMethod(this.getClass().getSimpleName(), "save", e.getMessage()));
			return null;
		}

	}

	@Override
	public List<CategoryDTO> getAllCategoriesByUser(Long idUser) {

		List<CategoryEntity> categories = categoryRepository.findAllByUser(mapperUtils.mapperEntityById(idUser));

		if (!CollectionUtils.isEmpty(categories)) {

			return categories.stream().map(category -> CategoryMapper.INSTANCE.entityToDTO(category))
					.collect(Collectors.toList());

		} else {
			return new ArrayList<>();
		}

	}

}
