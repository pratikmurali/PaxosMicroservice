package com.pratik.messages;

public class MessageNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String hexcode;

	public MessageNotFoundException(String hexcode) {
		super(String.format("Message not found for cryptohash : '%s'", hexcode));
		this.hexcode = hexcode;
	}

	public String getHexcode() {
		return hexcode;
	}

	public void setHexcode(String hexcode) {
		this.hexcode = hexcode;
	}

}
