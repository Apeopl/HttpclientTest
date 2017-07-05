package com.zjl.httpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpclientTest {
	public static void main(String[] args) {
		//1.创建httpclient实例
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//2.创建httpget实例
		HttpGet httpGet = new HttpGet("http://117.78.40.97:9010/secure/Dashboard.jspa");
		CloseableHttpResponse response = null;
		try {
			//3.执行http get请求
			response = httpClient.execute(httpGet);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//4.获取返回的实体
		HttpEntity entity = response.getEntity();
		//5.获取网页内容
		try {
			System.err.println("网页内容："+EntityUtils.toString(entity,"utf-8"));
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
		//6.关闭流
		try {
			response.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			httpClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
