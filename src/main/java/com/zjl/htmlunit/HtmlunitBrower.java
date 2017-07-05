package com.zjl.htmlunit;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HtmlunitBrower {
	public static void main(String[] args) {
		WebClient webClient = new WebClient(BrowserVersion.FIREFOX_52);
		try {
			HtmlPage page = webClient.getPage("http://www.java1234.com");
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
