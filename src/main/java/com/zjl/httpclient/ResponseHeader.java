package com.zjl.httpclient;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.message.BasicHttpResponse;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年7月27日 下午4:35:09 
*/
public class ResponseHeader {
	public static void main(String[] args) {
		HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
		response.addHeader("Set-Cookie", "c1=a; path=/; domain=localhost");
		response.addHeader("Set-Cookie", "c2=b; path=\"/\", c3=c; domain=\"localhost\"");
		/*Header h1 = response.getFirstHeader("Set-Cookie");
		Header h2 = response.getLastHeader("Set-Cookie");
		System.out.println(h1);
		System.out.println(h2);
		Header[] headers = response.getHeaders("Set-Cookie");
		System.out.println(headers.length);*/
		HeaderIterator iterator = response.headerIterator("Set-Cookie");
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}

