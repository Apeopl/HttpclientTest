package com.zjl.cxf;

import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import com.zjl.cxf.impl.User;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年9月23日 下午2:29:57 
*/
public class WebServiceClient {
	public static void main(String[] args) throws Exception {
		JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
		Client client = clientFactory.createClient("http://localhost:9090/service/theService?wsdl");
		QName name = new QName("http://service.common.hys.org/", "getUser");
		/*YyksAndYsQueryRequest request = new YyksAndYsQueryRequest();
		request.setYydm("361029001");
		request.setKsrq("20180103");
		request.setJsrq("20180109");*/
		Object[] objects = client.invoke(name,"lei",23);
		//Object[] objects = client.invoke(name,request);
		System.out.println(objects[0].toString());
		System.out.println(objects.length);
	}
}

