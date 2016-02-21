package com.niit.model;

import java.io.Serializable;

import android.R.integer;

public class UserModel implements Serializable {
	private int userid;
	private String username;
	private String userpwd;
	
	public UserModel() {
		super();
	}

	public UserModel(int userid, String username, String userpwd) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

}
