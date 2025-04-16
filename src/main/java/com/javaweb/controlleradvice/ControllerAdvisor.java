package com.javaweb.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.dto.response.ErrorDetailResponse;
import com.javaweb.myexception.ValidateDataBuildingException;

@RestControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ValidateDataBuildingException.class)
	public ResponseEntity<Object> handleValidateDataBuildingException(ValidateDataBuildingException ex){
		ErrorDetailResponse errorDetailReponse = new ErrorDetailResponse();
		errorDetailReponse.setError(ex.getMessage());
		return new ResponseEntity<Object>(errorDetailReponse, HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(Exception ex){
		ErrorDetailResponse errorDetailResponse = new ErrorDetailResponse();
		errorDetailResponse.setError(ex.getMessage());
		return new ResponseEntity<Object>(errorDetailResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<Object> handleNumberFormatException(Exception ex){
		ErrorDetailResponse errorDetailResponse = new ErrorDetailResponse();
		errorDetailResponse.setError(ex.getMessage());
		return new ResponseEntity<Object>(errorDetailResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
}
