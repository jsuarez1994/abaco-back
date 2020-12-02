package com.abaco.service;

import java.util.List;

public interface AbstractService<DTO> {

	/**
	 * Guardamos los elementos asociados al usuario
	 * @param dto
	 * @param idUser
	 * @return DTO
	 */
	DTO save(DTO dto, Long idUser);

	/**
	 * Obtienes todos los items a partir del usuario
	 * @param idUser
	 * @return List<DTO>
	 */
	List<DTO> getAllItemsByUser(Long idUser);

	/**
	 * Obtiene todos los item asociados a un usuario
	 * @param dto
	 * @param idUser
	 * @return
	 */
	int delete(DTO dto, Long idUser);

}
