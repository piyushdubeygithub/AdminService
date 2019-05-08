package com.prosmv.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prosmv.constants.url.ApiUrl;
import com.prosmv.dto.LoginResponseDTO;
import com.prosmv.dto.ResponseDTO;
import com.prosmv.form.LoginForm;
import com.prosmv.service.LoginService;
import com.prosmv.util.Constant;
import com.prosmv.util.ResponseHandler;
@CrossOrigin
@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = ApiUrl.USER_LOGIN, method = RequestMethod.POST)
	public ResponseEntity<ResponseDTO<LoginResponseDTO>> login(@Valid @RequestBody LoginForm loginForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.generateSuccesResponse(HttpStatus.BAD_REQUEST, true, Constant.ERROR,
					bindingResult.getAllErrors().get(0).getDefaultMessage(), null);
		}
		LoginResponseDTO loginResponseDTO = loginService.logIn(loginForm);
		if (loginResponseDTO != null) {
			return ResponseHandler.generateSuccessResponse(HttpStatus.OK, Boolean.FALSE, Constant.SUCCESS, loginResponseDTO);
		}
		return ResponseHandler.generateSuccessResponse(HttpStatus.BAD_REQUEST, true, Constant.ERROR, loginResponseDTO);
	}
	
	@RequestMapping(value = ApiUrl.USER_LOGOUT, method = RequestMethod.GET)
	public ResponseEntity<ResponseDTO<String>> logout(HttpServletRequest httpRequest) {
		  final String accessToken = httpRequest.getHeader("Authorization");
		String response = loginService.logOut(accessToken);
		if (response != null) {
			return ResponseHandler.generateSuccesResponse(HttpStatus.OK, false, Constant.SUCCESS, response, null);
		}
		return ResponseHandler.generateSuccesResponse(HttpStatus.BAD_REQUEST, false, Constant.ERROR, response, null);
	}
}
