package com.fxx.springboot.aware;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月21日 下午2:09:51 
*/
@Service
public class AwareService implements BeanNameAware,ResourceLoaderAware{
	private String beanName;
	private ResourceLoader loader;
	@Override
	public void setResourceLoader(ResourceLoader loader) {
		this.loader = loader;
	}

	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	public void outputResult(){
		System.out.println("bean的名称是："+beanName);
		Resource resource = loader.getResource("classpath:com/fxx/springboot/aware/aware.txt");
		try {
			System.out.println("加载的文件内容是："+IOUtils.toString(resource.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

