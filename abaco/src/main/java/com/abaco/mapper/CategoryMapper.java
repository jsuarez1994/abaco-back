package com.abaco.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.abaco.dto.CategoryDTO;
import com.abaco.entity.CategoryEntity;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends AbstractMapper<CategoryEntity, CategoryDTO> {

	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

}
