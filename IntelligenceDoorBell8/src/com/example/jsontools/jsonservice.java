package com.example.jsontools;

import com.example.allinformation.Person;
import com.example.allinformation.enter;
import com.example.allinformation.forgetinfo;

public class jsonservice {
     
	public jsonservice(){
		
	}
	
	public static Person getperson(String tel,String yanzheng,String nickname,String password,String confirmpassword)
	{
		Person person = new Person(tel,yanzheng,nickname,password,confirmpassword);
		return person;
	}
	
	public   static    enter  getenterinfo(String userName	 , String  userPass){
		  
		     enter  enterinfo    = new  enter(userName, userPass);
		     return  enterinfo;
		
	}
	
	public  static   forgetinfo  getforget(String phone ,String checkma ){
		     
		      forgetinfo forget = new forgetinfo(phone, checkma);
		  return      forget;
	}
	
}
