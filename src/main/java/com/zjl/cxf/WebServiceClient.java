package com.zjl.cxf;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年9月23日 下午2:29:57 
*/
public class WebServiceClient {
	public static void main(String[] args) throws Exception {
		JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
		Client client = clientFactory.createClient("http://www.webxml.com.cn/WebServices/IpAddressSearchWebService.asmx?wsdl");
		QName name = new QName("http://WebXml.com.cn/", "getCountryCityByIp");
		Object[] objects = client.invoke(name, "");
		System.out.println(objects[0].toString());
		System.out.println(objects.length);
	}
}

