package com.zjl.httpclient;

import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年7月27日 下午4:51:03 
*/
public class EntityTest {
	public static void main(String[] args) throws Exception{
		StringEntity entity = new StringEntity("hello entity", "UTF-8");
		System.out.println(entity.getContentType());
		System.out.println(entity.getContentLength());
		System.out.println(EntityUtils.getContentCharSet(entity));
		System.out.println(EntityUtils.toString(entity));
		System.out.println(EntityUtils.toByteArray(entity).length);
	}
}

