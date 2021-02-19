package com.unco.client.pojo;

public class User {

	private Integer id;
	private String username;
	private String password;
	private String name;
	private String sex;
	private String works;
	private String identity;
	private String head_images;

	public User() {
	}

	public User(Integer id, String username, String password, String name, String sex, String works, String identity, String head_images) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.works = works;
		this.identity = identity;
		this.head_images = head_images;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getWorks() {
		return works;
	}

	public void setWorks(String works) {
		this.works = works;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getHead_images() {
		return head_images;
	}

	public void setHead_images(String head_images) {
		this.head_images = head_images;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", sex="
				+ sex + ", works=" + works + ", identity=" + identity + "]";
	}

	
	
	
}
