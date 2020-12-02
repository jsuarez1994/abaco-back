package com.abaco.service;

import com.abaco.dto.UserDTO;

public interface UserService {

	/**
	 * Guardamos elemento
	 * @param dto
	 * @return UserDTO
	 */
	UserDTO save(UserDTO dto);

	/**
	 * Login de usuario
	 * @param email
	 * @param password
	 * @return Boolean
	 */
	Boolean login(final String email, final String password);
	
	
	/**
	 * Obtiene el usuario a partir del id
	 * @param id
	 * @return UserDTO
	 */
	UserDTO getUserById(Long id);
}
