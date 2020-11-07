package com.abaco.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abaco.entity.UserEntity;
import com.abaco.util.LogUtil;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MapperUtils {

	@Autowired
	LogUtil logUtil;

	public UserEntity mapperEntityById(Long id) {
		try {
			UserEntity object = new UserEntity();
			object.setId(id);
			return object;
		} catch (Exception e) {
			log.error(logUtil.errorMethod(this.getClass().getSimpleName(), "mapperEntityById", e.getMessage()));
			return null;
		}
	}

}
