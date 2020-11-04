package com.abaco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abaco.dto.UserDTO;
import com.abaco.entity.UserEntity;
import com.abaco.mapper.UserMapper;
import com.abaco.repository.AbstractRepository;
import com.abaco.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	AbstractRepository<UserEntity> abstractUserRepository;

	@Override
	public UserDTO save(UserDTO user) {
		return UserMapper.INSTANCE.entityToDTO(abstractUserRepository.save(UserMapper.INSTANCE.DTOtoEntity(user)));
	}

}
