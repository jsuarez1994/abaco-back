package com.abaco.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.abaco.dto.UserDTO;
import com.abaco.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper extends AbstractMapper<UserEntity, UserDTO> {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

}
