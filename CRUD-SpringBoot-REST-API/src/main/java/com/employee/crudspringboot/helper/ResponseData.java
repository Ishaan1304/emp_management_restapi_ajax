package com.employee.crudspringboot.helper;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseData {
	
	private String status;
	private long statusCode;
	private String message;
	private String role;
	private Object data;
	
	

}
