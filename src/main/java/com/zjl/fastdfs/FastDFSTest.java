package com.zjl.fastdfs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

/** 
* 描述：
* @author zhengjinlei 
* @version 2018年1月23日 下午4:25:41 
*/
public class FastDFSTest {
	public static void main(String[] args) throws Exception{
		String configFile = "C:\\Users\\king-zheng\\git\\fastdfs-client-java\\fdfs_client.conf";
		try {
			ClientGlobal.init(configFile);
		} catch (IOException | MyException e) {
			e.printStackTrace();
		}
		File file = new File("D:"+File.separator+"ZZZ"+File.separator+"资料"+File.separator+"34张史上最全IT架构师技术知识图谱"+File.separator+"1.9 设计模式秘籍图谱.jpg");
		String[] files = uploadFile(file,".png",file.length());
		System.out.println(Arrays.asList(files));
	}

	private static String[] uploadFile(File file, String uploadFileName, long length) throws FileNotFoundException, IOException {
		byte[] fileBuffer = getFileBuffer(new FileInputStream(file),length);
		String[] files = null;
        String fileExtName = "";
        if (uploadFileName.contains(".")) {
            fileExtName = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
        } else {
            System.out.println("Fail to upload file, because the format of filename is illegal.");
            return null;
        }
        //建立连接
        TrackerClient tracker = new TrackerClient();
        TrackerServer server = tracker.getConnection();
        StorageServer storageServer = null;
        StorageClient client = new StorageClient(server, storageServer);
        NameValuePair[] metaList = new NameValuePair[3];
        metaList[0] = new NameValuePair("fileName", uploadFileName);
        metaList[1] = new NameValuePair("fileExtName", fileExtName);
        metaList[2] = new NameValuePair("fileLength", String.valueOf(length));
        try {
			files = client.upload_file(fileBuffer, fileExtName, metaList);
		} catch (MyException e) {
			e.printStackTrace();
		}
        server.close();
		return files;
	}

	private static byte[] getFileBuffer(FileInputStream fileInputStream, long length) throws IOException {
		byte[] buffer = new byte[256*1024];
		byte[] fileBuffer = new byte[(int) length];
		int count = 0;
		int len = 0;
		while((len=fileInputStream.read(buffer)) != -1){
			for(int i=0; i<len; i++){
				fileBuffer[count+i] = buffer[i];
			}
			count += len;
		}
		return fileBuffer;
	}
}

