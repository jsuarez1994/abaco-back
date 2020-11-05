package com.abaco.service.impl;

import java.util.stream.Collectors;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abaco.dto.UserDTO;
import com.abaco.entity.UserEntity;
import com.abaco.internal.object.CategoriesDefault;
import com.abaco.mapper.CategoryMapper;
import com.abaco.mapper.UserMapper;
import com.abaco.repository.AbstractRepository;
import com.abaco.repository.UserRepository;
import com.abaco.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	AbstractRepository<UserEntity> abstractUserRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CategoriesDefault categoriesDefault;

	@Override
	public UserDTO save(UserDTO dto) {

		// Pasamos el objeto a entidad
		UserEntity entity = UserMapper.INSTANCE.DTOtoEntity(dto);

		// A la hora de registrar le pasamos las categorias por defecto
		entity.setCategories(categoriesDefault.getProperties().stream()
				.map(cat -> CategoryMapper.INSTANCE.DTOtoEntity(cat)).collect(Collectors.toList()));

		return UserMapper.INSTANCE.entityToDTO(abstractUserRepository.save(entity));
	}

	@Override
	public Boolean login(final String email, final String password) {

		return (!ObjectUtils.isNotEmpty(userRepository.findByEmailAndPassword(email, password))) ? Boolean.TRUE
				: Boolean.FALSE;

	}

}
