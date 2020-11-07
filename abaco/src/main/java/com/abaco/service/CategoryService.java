package com.abaco.service;

import java.util.List;

import com.abaco.dto.CategoryDTO;

public interface CategoryService {

	CategoryDTO save(CategoryDTO dto, Long idUser);
	
	List<CategoryDTO> getAllCategoriesByUser(Long idUser);

}
