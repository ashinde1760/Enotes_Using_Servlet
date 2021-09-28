package com.User;

import java.util.Date;

public class Notes {
	private int id;
	private String title,content;
	private Date date;
	private UserDetails ud;
	public Notes() {
		super();
	}
	public Notes(int id, String title, String content, Date date, UserDetails ud) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.date = date;
		this.ud = ud;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public UserDetails getUd() {
		return ud;
	}
	public void setUd(UserDetails ud) {
		this.ud = ud;
	}
	
	
}
