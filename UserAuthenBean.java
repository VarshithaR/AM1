package com.cg.asset.bean;

public class UserAuthenBean {

	
	private String userid;
	private String pwd;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public UserAuthenBean(String userid, String pwd) {
		super();
		this.userid = userid;
		this.pwd = pwd;
	}
	public UserAuthenBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
