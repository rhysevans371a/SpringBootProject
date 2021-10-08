package com.qa.spring.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)

//	Custom exception extending RuntimeException for when no matching products are found
public class ProductNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;

	public ProductNotFoundException(String message) {
		this.message = message;
	}
}
