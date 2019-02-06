package com.example.restfull.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.restfull.exception.PersonNotFoundException;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	@ExceptionHandler(PersonNotFoundException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ApiErrorResponse handleException(final PersonNotFoundException e,
			final HttpServletRequest request, HttpStatus status) {

		ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder()
				.withStatus(status)
				.withErrorCode(status.BAD_REQUEST.name())
				.withPath(request.getRequestURI())
				.withMessage(e.getLocalizedMessage()).build();

		return response;
	}

}
