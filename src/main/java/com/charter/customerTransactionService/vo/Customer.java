package com.charter.customerTransactionService.vo;

public class Customer {

	
	private Long cutomerId;
	private String cutomerName;
	private String address;
	private String email;
	private String phone;
	
	public Long getCutomerId() {
		return cutomerId;
	}
	public void setCutomerId(Long cutomerId) {
		this.cutomerId = cutomerId;
	}
	public String getCutomerName() {
		return cutomerName;
	}
	public void setCutomerName(String cutomerName) {
		this.cutomerName = cutomerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
