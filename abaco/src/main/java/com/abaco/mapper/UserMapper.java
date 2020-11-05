package com.abaco.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.abaco.dto.UserDTO;
import com.abaco.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	UserDTO entityToDTO(UserEntity entity);

	UserEntity DTOtoEntity(UserDTO dto);

}
