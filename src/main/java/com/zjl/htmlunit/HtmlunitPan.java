package com.zjl.htmlunit;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HtmlunitPan {
	public static void main(String[] args) throws InterruptedException {
		WebClient webClient = new WebClient();
		try {
			HtmlPage page = webClient.getPage("https://pan.baidu.com/share/home?uk=305605848#category/type=0");
			Thread.sleep(10000);
			System.err.println("网页html："+page.asXml());
		} catch (FailingHttpStatusCodeException | IOException e) {
			e.printStackTrace();
		} finally{
			webClient.close();
		}
	}
}
