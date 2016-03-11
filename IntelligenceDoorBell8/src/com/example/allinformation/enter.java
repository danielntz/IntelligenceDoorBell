package com.example.allinformation;

public class enter {

	   public String userName;
	   public  String userPass;
	   
	   public   enter(){
		   
	   }

	public enter(String userName, String userPass) {
		super();
		this.userName = userName;
		this.userPass = userPass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	   
	
	
}
