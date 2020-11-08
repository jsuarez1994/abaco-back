package com.abaco.mapper;

import java.util.List;

public interface AbstractMapper <ENTITY, DTO>{

	DTO entityToDTO(ENTITY entity);
	
	List<DTO> listEntityToDTO(List<ENTITY> listEntity);

	ENTITY DTOtoEntity(DTO dto);
	
	List<ENTITY> listDTOToEntity(List<DTO> listDTO);
	
}
