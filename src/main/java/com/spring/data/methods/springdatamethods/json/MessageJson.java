package com.spring.data.methods.springdatamethods.json;

public class MessageJson {

	public MessageJson(String message){
		this.message = message;
	}
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
