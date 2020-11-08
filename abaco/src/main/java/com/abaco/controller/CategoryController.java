package com.abaco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abaco.dto.CategoryDTO;
import com.abaco.service.CategoryService;
import com.abaco.util.EndPointsConstants;
import com.abaco.util.SwaggerConstants;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(EndPointsConstants.EP_CATEGORY_CONTROLLER)
@Slf4j
public class CategoryController extends BaseController{

	@Autowired
	private CategoryService categoryService;

	/**
	 * Guardar elemento Categoria
	 * 
	 * @param dto
	 * @return CategoryDTO
	 */
	@ApiOperation(value = SwaggerConstants.AO_CATEGORYCONTROLLER_SAVE)
	@PostMapping(path = EndPointsConstants.EP_CATEGORY_CONTROLLER_SAVE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@RequestBody CategoryDTO dto) {

		final String methodName = "save";

		log.info(logUtil.initMethod(this.getClass().getSimpleName(), methodName));
		try {

			// TODO: OBTENER ID DE USUARIO LOGADO
			Long id = 2L;

			CategoryDTO saved = categoryService.save(dto, id);
			log.info(logUtil.finishMethod(this.getClass().getSimpleName(), methodName));
			if (null != saved) {
				return ResponseEntity.ok(saved);
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
			}
		} catch (Exception e) {
			log.error(logUtil.errorMethod(this.getClass().getSimpleName(), methodName, e.getMessage()));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	/**
	 * Retorna todas las categorias por usuario
	 * 
	 * @return List<CategoryDTO>
	 */
	@ApiOperation(value = SwaggerConstants.AO_CATEGORYCONTROLLER_GETALLBYUSER)
	@PostMapping(path = EndPointsConstants.EP_CATEGORY_CONTROLLER_GETALLBYUSER, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getAllByUser() {

		final String methodName = "getAllByUser";

		log.info(logUtil.initMethod(this.getClass().getSimpleName(), methodName));
		try {

			// TODO: OBTENER ID DE USUARIO LOGADO
			Long id = 2L;

			List<CategoryDTO> categories = categoryService.getAllItemsByUser(id);
			log.info(logUtil.finishMethod(this.getClass().getSimpleName(), methodName));
			return ResponseEntity.ok(categories);

		} catch (Exception e) {
			log.error(logUtil.errorMethod(this.getClass().getSimpleName(), methodName, e.getMessage()));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	/**
	 * Elimina payment
	 * 
	 * @return List<PaymentDTO>
	 */
	@ApiOperation(value = SwaggerConstants.AO_CATEGORYCONTROLLER_DELETE)
	@DeleteMapping(path = EndPointsConstants.EP_CATEGORY_CONTROLLER_DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> delete(@RequestBody CategoryDTO dto) {

		final String methodName = "delete";

		log.info(logUtil.initMethod(this.getClass().getSimpleName(), methodName));
		try {

			// TODO: OBTENER ID DE USUARIO LOGADO
			Long id = 2L;

			int register = categoryService.delete(dto, id);
			log.info(logUtil.finishMethod(this.getClass().getSimpleName(), methodName));
			return ResponseEntity.ok((register == 0) ? Boolean.FALSE : Boolean.TRUE);

		} catch (Exception e) {
			log.error(logUtil.errorMethod(this.getClass().getSimpleName(), methodName, e.getMessage()));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
