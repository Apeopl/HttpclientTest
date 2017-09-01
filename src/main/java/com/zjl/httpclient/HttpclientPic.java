package com.zjl.httpclient;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import cn.edu.hfut.dmic.webcollector.util.FileUtils;

public class HttpclientPic {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://www.java1234.com/gg/dljd4.gif");
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
		CloseableHttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		if(null!=entity){
			System.err.println("ContentType："+entity.getContentType().getValue());
			InputStream inputStream = entity.getContent();
			//FileUtils.copyToFile(inputStream, new File("D:/first.gif"));
		}
		/*response.close();
		httpClient.close();*/
	}
}
