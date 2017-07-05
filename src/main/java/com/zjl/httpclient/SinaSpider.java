package com.zjl.httpclient;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 网页爬虫
 * @author king-zheng
 *
 */
public class SinaSpider {
	public static void main(String[] args) {
		URL url = null;
		URLConnection urlConn = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		String regex = "http://[\\w+\\.?/?]+\\.[A-Za-z]+";
		Pattern pattern = Pattern.compile(regex);
		try {
			url = new URL("http://www.sina.com.cn/");
			urlConn = url.openConnection();
			pw = new PrintWriter(new FileWriter("d:/sina.txt"));
			br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			String buf = null;
			while((buf = br.readLine()) != null){
				Matcher matcher = pattern.matcher(buf);
				while(matcher.find()){
					pw.println(matcher.group());
				}
			}
			System.out.println("读取完毕！");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			pw.close();
		}
	}
}
