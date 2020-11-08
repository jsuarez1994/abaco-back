package com.abaco.service.impl;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abaco.dto.UserDTO;
import com.abaco.entity.UserEntity;
import com.abaco.internal.validation.UserValidation;
import com.abaco.mapper.UserMapper;
import com.abaco.repository.UserRepository;
import com.abaco.service.CategoryService;
import com.abaco.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	CategoryService categoryService;

	@Autowired
	UserValidation userValidation;

	@Override
	public UserDTO save(UserDTO dto) {

		try {
			if (userValidation.validatePorcent(dto)) {
				// Pasamos el objeto a entidad
				UserEntity entity = userRepository.save(UserMapper.INSTANCE.DTOtoEntity(dto));

				categoriesDefault.getProperties().stream().forEach(category -> {
					categoryService.save(category, entity.getId());
				});

				return UserMapper.INSTANCE.entityToDTO(entity);
			} else {
				return null;
			}
		} catch (Exception e) {
			log.error(logUtil.errorMethod(this.getClass().getSimpleName(), "save", e.getMessage()));
			return null;
		}

	}

	@Override
	public Boolean login(final String email, final String password) {
		return (ObjectUtils.isNotEmpty(userRepository.findByEmailAndPassword(email, password))) ? Boolean.TRUE
				: Boolean.FALSE;
	}

}
