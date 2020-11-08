package com.abaco.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.abaco.dto.CategoryDTO;
import com.abaco.entity.CategoryEntity;
import com.abaco.entity.UserEntity;
import com.abaco.internal.validation.CategoryValidation;
import com.abaco.mapper.CategoryMapper;
import com.abaco.repository.CategoryRepository;
import com.abaco.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryServiceImpl extends BaseServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	CategoryValidation categoryValidation;

	@Override
	public CategoryDTO save(CategoryDTO dto, Long idUser) {

		try {
			UserEntity userEntity = mapperUtils.mapperEntityById(idUser);

			CategoryEntity entity = CategoryMapper.INSTANCE.DTOtoEntity(dto);

			// Verificamos si existe el objeto en BD
			Optional<CategoryEntity> itemBD = categoryRepository.findByDescriptionAndTypeAndNatureAndUser(
					StringUtils.trimToNull(dto.getDescription()), dto.getType(), dto.getNature(), userEntity);

			// Si existe seteamos el ID para actualizarlo
			if (itemBD.isPresent()) {
				entity.setId(itemBD.get().getId());
			}

			entity.setUser(userEntity);
			return CategoryMapper.INSTANCE.entityToDTO(categoryRepository.save(entity));

		} catch (Exception e) {
			log.error(logUtil.errorMethod(this.getClass().getSimpleName(), "save", e.getMessage()));
			return null;
		}

	}

	@Override
	public List<CategoryDTO> getAllItemsByUser(Long idUser) {

		List<CategoryEntity> list = categoryRepository.findAllByUser(mapperUtils.mapperEntityById(idUser));

		return (!CollectionUtils.isEmpty(list)) ? CategoryMapper.INSTANCE.listEntityToDTO(list) : new ArrayList<>();

	}

	@Override
	public int delete(CategoryDTO dto, Long idUser) {

		try {
			Optional<CategoryEntity> category = categoryRepository.findByDescriptionAndTypeAndNatureAndUser(
					StringUtils.trimToNull(dto.getDescription()), dto.getType(), dto.getNature(),
					mapperUtils.mapperEntityById(idUser));

			if (category.isPresent()) {
				categoryRepository.delete(category.get());
				return 1;
			} else {
				return 0;
			}

		} catch (Exception e) {
			log.error(logUtil.errorMethod(this.getClass().getSimpleName(), "delete", e.getMessage()));
			return 0;
		}

	}

}
