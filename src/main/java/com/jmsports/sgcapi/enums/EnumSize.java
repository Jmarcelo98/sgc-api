package com.jmsports.sgcapi.enums;

public enum EnumSize {
	
	P("p"),
	M("m"),
	G("g"),
	GG("gg");
	
	private String size;
	
	private EnumSize(String size) {
		this.size = size;
	}

	public String getSize() {
		return size;
	}
	
	

}
