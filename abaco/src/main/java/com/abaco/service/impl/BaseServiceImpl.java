package com.abaco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.abaco.internal.object.CategoriesDefault;
import com.abaco.mapper.MapperUtils;
import com.abaco.util.LogUtil;

public class BaseServiceImpl {

	@Autowired
	LogUtil logUtil;

	@Autowired
	MapperUtils mapperUtils;
	
	@Autowired
	CategoriesDefault categoriesDefault;
	
}
