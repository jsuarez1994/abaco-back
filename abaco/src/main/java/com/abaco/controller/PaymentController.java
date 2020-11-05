//package com.abaco.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.abaco.dto.UserDTO;
//import com.abaco.service.UserService;
//import com.abaco.util.EndPointsConstants;
//import com.abaco.util.SwaggerConstants;
//
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping(EndPointsConstants.EP_USER_CONTROLLER)
//@Slf4j
//public class PaymentController {
//
//	@Autowired
//	UserService userService;
//
//	/**
//	 * Guardar elemento Usuario
//	 * 
//	 * @param user
//	 * @return UserDTO
//	 */
//	@ApiOperation(value = SwaggerConstants.AO_USERCONTROLLER_SAVE)
//	@PostMapping(path = EndPointsConstants.EP_USER_CONTROLLER_SAVE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Object> save(@RequestBody UserDTO user) {
//		log.info("### Inicio UserController.save ###");
//		try {
//			UserDTO saved = userService.save(user);
//			log.info("### Fin UserController.save ###");
//			return ResponseEntity.ok(saved);
//		} catch (Exception e) {
//			log.error("### Error en UserController.save :", e.getMessage(), " ###");
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//		}
//	}
//
//	/**
//	 * Login Usuario
//	 * 
//	 * @param email
//	 * @param password
//	 * @return Boolean
//	 */
//	@ApiOperation(value = SwaggerConstants.AO_USERCONTROLLER_LOGIN)
//	@PostMapping(path = EndPointsConstants.EP_USER_CONTROLLER_LOGIN, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Object> login(@RequestParam final String mail, @RequestParam final String password) {
//		log.info("### Inicio UserController.login ###");
//		try {
//			Boolean loged = userService.login(mail, password);
//			log.info("### Fin UserController.login ###");
//			return ResponseEntity.ok(loged);
//		} catch (Exception e) {
//			log.error("### Error en UserController.login :", e.getMessage(), " ###");
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//		}
//	}
//}
