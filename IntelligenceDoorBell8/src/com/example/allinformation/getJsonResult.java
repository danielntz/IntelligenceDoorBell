package com.example.allinformation;
/**
 * 登录成功后，解析服务器返回的json字符串得到账户名在app中显示
 * @author jsjxy
 *
 */
public class getJsonResult {
        
	          private   String  userNick;
	          
	          public   getJsonResult(){
	        	  
	          }

			public getJsonResult(String userNick) {
				super();
				this.userNick = userNick;
			}

			public String getUserNick() {
				return userNick;
			}

			public void setUserNick(String userNick) {
				this.userNick = userNick;
			}
	
	      
	
}
