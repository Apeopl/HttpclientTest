package com.zjl.htmlunit;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class HtmlunitButton {
	public static void main(String[] args) {
		WebClient webClient = new WebClient();
		try {
			HtmlPage page = webClient.getPage("http://blog.java1234.com/index.html");
			HtmlForm form = page.getFormByName("myform");
			HtmlTextInput input = form.getInputByName("q");
			HtmlSubmitInput submit = form.getInputByName("submitButton");
			input.setValueAttribute("java");
			HtmlPage page2 = submit.click();
			System.err.println(page2.asXml());
		} catch (FailingHttpStatusCodeException | IOException e) {
			e.printStackTrace();
		} finally{
			webClient.close();
		}
	}
}
