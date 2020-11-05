package com.abaco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abaco.dto.CategoryDTO;
import com.abaco.service.CategoryService;
import com.abaco.util.EndPointsConstants;
import com.abaco.util.LogUtil;
import com.abaco.util.SwaggerConstants;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(EndPointsConstants.EP_CATEGORY_CONTROLLER)
@Slf4j
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	LogUtil logUtil;

	/**
	 * Guardar elemento Usuario
	 * 
	 * @param user
	 * @return UserDTO
	 */
	@ApiOperation(value = SwaggerConstants.AO_CATEGORYCONTROLLER_SAVE)
	@PostMapping(path = EndPointsConstants.EP_CATEGORY_CONTROLLER_SAVE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@RequestBody CategoryDTO user) {
		log.info(logUtil.initMethod(this.getClass().getSimpleName(), "save"));
		try {
			CategoryDTO saved = categoryService.save(user);
			log.info(logUtil.finishMethod(this.getClass().getSimpleName(), "save"));
			if (null != saved) {
				return ResponseEntity.ok(saved);
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
			}
		} catch (Exception e) {
			log.error(logUtil.errorMethod(this.getClass().getSimpleName(), "save", e.getMessage()));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
