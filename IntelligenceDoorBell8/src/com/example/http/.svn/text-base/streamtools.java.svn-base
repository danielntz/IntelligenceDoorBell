package com.example.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
  /**
   * 
   * @author 把输入流里面的内容转化成字符串,定义内存输出流，把输入流的内容放到输出流中，在从输出流读内容，显示出来
   *
   */
public class streamtools    {
    
	 public static String readInputStream(InputStream is){
		 ByteArrayOutputStream baos = new ByteArrayOutputStream();
		 int len = 0;
		 byte[] buffer = new byte[1024];
		 
		  try {
			while((len = is.read(buffer))!= -1){
				  baos.write(buffer,0,len);
			  }
			is.close();
			baos.close();
			byte[] result = baos.toByteArray();
			return new String(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	 }
	
}
