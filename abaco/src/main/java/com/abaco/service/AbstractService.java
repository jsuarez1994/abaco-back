package com.abaco.service;

import java.util.List;

public interface AbstractService<DTO> {

	DTO save(DTO dto, Long idUser);

	List<DTO> getAllItemsByUser(Long idUser);

	int delete(DTO dto, Long idUser);

}
