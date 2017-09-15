package com.sovanm.websocketdemo.dto;

public class MessageDTO {

	public String message;
	public String from;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	@Override
	public String toString() {
		return "MessageDTO [message=" + message + ", from=" + from + "]";
	}

}
