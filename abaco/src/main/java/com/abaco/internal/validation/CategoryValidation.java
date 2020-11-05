package com.abaco.internal.validation;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abaco.dto.CategoryDTO;
import com.abaco.entity.UserEntity;
import com.abaco.repository.CategoryRepository;

@Component
public class CategoryValidation {

	@Autowired
	CategoryRepository categoryRepository;

	/**
	 * Validamos los campos descripcion, nature y type si existe ya esa Categoria
	 * para ese usuario
	 * 
	 * @param dto
	 * @param idUser
	 * @return
	 */
	public boolean validToSave(CategoryDTO dto, UserEntity idUser) {
		boolean valid = false;

		if (null != StringUtils.trimToNull(dto.getDescription()) && ObjectUtils.allNotNull(dto.getType())
				&& ObjectUtils.allNotNull(dto.getNature())) {

			if (ObjectUtils.isEmpty(categoryRepository.findByDescriptionAndTypeAndNatureAndUser(
					StringUtils.trimToNull(dto.getDescription()), dto.getType(), dto.getNature(), idUser))) {
				return true;
			}

		}

		return valid;
	}

}
