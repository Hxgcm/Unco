package com.unco.client.pojo;

import com.sun.org.apache.bcel.internal.generic.DADD;

import java.util.Date;

public class Works {
	
	private int id;
	private String title;
	private String category ="人像";
	private String imgurl;
	private String author;
	private String describe;
	private Date upload_time;

	public Works() {
	}

	public Works(int id, String title, String category, String imgurl, String author, String describe, Date upload_time) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.imgurl = imgurl;
		this.author = author;
		this.describe = describe;
		this.upload_time = upload_time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Date getUpload_time() {
		return upload_time;
	}

	public void setUpload_time(Date upload_time) {
		this.upload_time = upload_time;
	}

	@Override
	public String toString() {
		return "Works{" +
				"id=" + id +
				", title='" + title + '\'' +
				", category='" + category + '\'' +
				", imgurl='" + imgurl + '\'' +
				", author='" + author + '\'' +
				", describe='" + describe + '\'' +
				", upload_time='" + upload_time + '\'' +
				'}';
	}
}
