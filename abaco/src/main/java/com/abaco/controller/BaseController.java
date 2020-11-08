package com.abaco.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.abaco.util.LogUtil;

public class BaseController {

	/**
	 * Clase para inyectar todas las dependencias comunes
	 */

	@Autowired
	LogUtil logUtil;

}
