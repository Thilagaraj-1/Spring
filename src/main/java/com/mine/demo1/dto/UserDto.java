package com.mine.demo1.dto;

public class UserDto {
	private String name;
	private String email;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public UserDto(String name, String email, String address) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
	}
}
