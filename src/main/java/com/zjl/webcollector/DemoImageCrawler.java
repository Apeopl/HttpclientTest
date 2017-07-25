package com.zjl.webcollector;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.util.Config;
import cn.edu.hfut.dmic.webcollector.util.FileUtils;

/** 
* 描述：爬取图片
* @author zhengjinlei 
* @version 2017年7月25日 下午1:37:00 
*/
public class DemoImageCrawler extends BreadthCrawler{
	File downloadDir;//用于保存图片的文件夹
	AtomicInteger imageId;//原子性，用于生成图片的文件名
	/**
	 * 
	 * @param crawlPath 用于维护URL的文件夹
	 * @param downloadPath 用于保存图片的文件夹
	 */
	public DemoImageCrawler(String crawlPath, String downloadPath) {
		super(crawlPath, true);
		downloadDir = new File(downloadPath);
		if(!downloadDir.exists()){
			downloadDir.mkdirs();
		}
		computeImageId();
	}
	
	@Override
	public void visit(Page page, CrawlDatums next) {
		//根据http头中的Content-Type信息来判断当前资源是网页还是图片
		String contentType = page.getResponse().getContentType();
		if(null == contentType){
			return ;
		}else if(contentType.contains("html")){
			//如果是网页，则抽取其中包含图片的URL，放入后续任务
			Elements imgs = page.select("img[src]");
			for (Element img : imgs) {
				String imgSrc = img.attr("abs:src");
				next.add(imgSrc);
			}
		}else if(contentType.contains("image")){
			//如果是图片，直接下载
			String extensionName = contentType.split("/")[1];
			String imageFileName = imageId.incrementAndGet() + "." + extensionName;
			File imageFile = new File(downloadDir, imageFileName);
			try {
				FileUtils.writeFile(imageFile, page.getContent());
				System.out.println("保存图片"+page.getUrl()+"到"+imageFile.getAbsolutePath());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void computeImageId() {
		int maxId = -1;
		for(File imageFile:downloadDir.listFiles()){
			String fileName = imageFile.getName();
			String idStr = fileName.split("\\.")[0];
			int id = Integer.valueOf(idStr);
			if(id>maxId){
				maxId = id;
			}
		}
		imageId = new AtomicInteger(maxId);
	}
	public static void main(String[] args) throws Exception {
		DemoImageCrawler demo = new DemoImageCrawler("D:\\ZZZ\\Exercise\\webcollector\\temp","D:\\ZZZ\\Exercise\\webcollector\\baidu");
		//添加种子url
		demo.addSeed("https://www.baidu.com/");
		//限定爬取范围
		demo.addRegex("https://www.baidu.com/.*");
		//设置为断点爬取，否则每次开启爬虫都会重新爬取
		demo.setResumable(false);
		demo.setThreads(30);
		Config.MAX_RECEIVE_SIZE = 1000*1000*10;
		demo.start(3);
	}
}

