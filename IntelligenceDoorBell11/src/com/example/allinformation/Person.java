package com.example.allinformation;

public class Person  {
      
	private String userName;     //用户所填手机号
	private String deviceId;                //设备编号
	private String userNick;              //用户昵称
	private String userPass;            //用户所填的密码
	private String  userConpass;     //用户确认密码
	
	
	public Person(String userName, String deviceId, String userNick,
			String userPass, String userConpass) {
		
		this.userName = userName;
		this.deviceId = deviceId;
		this.userNick = userNick;
		this.userPass = userPass;
		this.userConpass = userConpass;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getDeviceId() {
		return deviceId;
	}


	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}


	public String getUserNick() {
		return userNick;
	}


	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}


	public String getUserPass() {
		return userPass;
	}


	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}


	public String getUserConpass() {
		return userConpass;
	}


	public void setUserConpass(String userConpass) {
		this.userConpass = userConpass;
	}
	
	
	//public String toString(){
          
	//	return "[tel="+tel+",yanzheng="+yanzhengma+",nickname="+nickname+",password="+password+",confirmpassword="+confirmpassword+"]";
	//}
	
	
	
}
