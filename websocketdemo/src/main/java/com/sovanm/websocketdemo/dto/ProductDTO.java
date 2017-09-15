package com.sovanm.websocketdemo.dto;

public class ProductDTO {

	private String name;
	private String code;
	private String price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ProductDTO [name=" + name + ", code=" + code + ", price=" + price + "]";
	}

}
