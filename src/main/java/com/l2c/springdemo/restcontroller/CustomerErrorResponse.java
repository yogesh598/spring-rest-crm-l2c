package com.l2c.springdemo.restcontroller;

public class CustomerErrorResponse {

	private int stamp;
	private String message;
	private long timeStamp;
	
	public CustomerErrorResponse() {
		
	}

	public CustomerErrorResponse(int stamp, String message, long timeStamp) {
		super();
		this.stamp = stamp;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public int getStamp() {
		return stamp;
	}

	public void setStamp(int stamp) {
		this.stamp = stamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	  
}
