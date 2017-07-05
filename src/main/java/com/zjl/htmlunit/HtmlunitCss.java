package com.zjl.htmlunit;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HtmlunitCss {
	public static void main(String[] args) {
		WebClient webClient = new WebClient();
		webClient.getOptions().setCssEnabled(false);//取消css支持
		webClient.getOptions().setJavaScriptEnabled(false);//取消javascript支持
		try {
			HtmlPage page = webClient.getPage("http://www.baidu.com");
			System.err.println("网页html："+page.asXml());
			System.out.println("===================");
			System.err.println("网页文本："+page.asText());
		} catch (FailingHttpStatusCodeException | IOException e) {
			e.printStackTrace();
		} finally{
			webClient.close();
		}
	}
}
