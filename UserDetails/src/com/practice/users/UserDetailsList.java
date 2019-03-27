package com.practice.users;

public class UserDetailsList {
	
	private String name;
	private Integer age;
	private String company;
	private String address;
	
	public UserDetailsList(String name, Integer age, String company, String address) {
		this.name = name;
		this.age = age;
		this.company =company;
		this.address = address;
	}
	
	public UserDetailsList() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

		public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
