package com.zjl.htmlunit;

import java.io.IOException;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlListItem;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;

public class HtmlunitElement {
	public static void main(String[] args) {
		WebClient webClient = new WebClient(BrowserVersion.FIREFOX_52,"117.143.109.146",80);
		try {
			HtmlPage page = webClient.getPage("http://www.java1234.com");
			//根据id来查询
			/*HtmlDivision div = page.getHtmlElementById("navMenu");
			System.err.println(div.asText());
			System.out.println("=======================");
			System.err.println(div.asXml());*/
			//根据标签来查询
			/*DomNodeList<DomElement> nodeList = page.getElementsByTagName("a");
			for (DomElement domElement : nodeList) {
				System.err.println(domElement.asXml());
			}*/
			//xpath来获取
			List<HtmlSpan> spans = page.getByXPath("//div[@id='navMenu']/ul/li[2]/a/span");
			System.err.println(spans.get(0).asXml());
			System.err.println(spans.get(0).asText());
		} catch (FailingHttpStatusCodeException | IOException e) {
			e.printStackTrace();
		} finally{
			webClient.close();
		}
	}
}
