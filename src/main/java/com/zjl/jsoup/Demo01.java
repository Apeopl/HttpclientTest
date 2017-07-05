package com.zjl.jsoup;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Demo01 {
	public static void main(String[] args) throws Exception{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://www.cnblogs.com/");
		//httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
		CloseableHttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		String content = EntityUtils.toString(entity, "utf-8");
		response.close();
		Document doc = Jsoup.parse(content);
		Elements elements = doc.getElementsByTag("title");
		Element element = elements.get(0);
		String title = element.text();
		System.err.println("网页标题："+title);
		Element element2 = doc.getElementById("site_nav_top");
		String kouhao = element2.text();
		System.err.println("口号是："+kouhao);
		Elements classElements = doc.getElementsByClass("post_item");
		/*for (Element classElement : classElements) {
			System.err.println(classElement.html());
			System.out.println("--------------------");
		}*/
		Elements attrEles = doc.getElementsByAttribute("width");
		/*for (Element attrEle : attrEles) {
			System.err.println(attrEle.toString());
			System.out.println("-------------------------");
		}*/
		Elements valEles = doc.getElementsByAttributeValue("width", "48");
		/*for (Element valEle : valEles) {
			System.err.println(valEle.toString());
			System.out.println("---------------------------");
		}*/
		Elements links = doc.select("#post_list .post_item .post_item_body h3 a");
		/*for (Element link : links) {
			System.err.println("标题是："+link.text());
			System.err.println("博客地址是："+link.attr("href"));
			System.err.println("target："+link.attr("target"));
			System.out.println("--------------------------");
		}*/
		Elements hrefs = doc.select("a[href]");
		/*for (Element href : hrefs) {
			System.err.println(href.toString());
		}*/
		Elements imgs = doc.select("img[src$=.png]");
		/*for (Element img : imgs) {
			System.err.println(img.toString());
		}*/
		Element ti = doc.getElementsByTag("title").first();
		//System.err.println(ti.text());
		Element a = doc.select("#friend_link").first();
		System.err.println(a.text());
		System.err.println(a.html());
	}
}
