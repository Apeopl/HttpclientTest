package test;

import java.io.IOException;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.DeleteRowsEventData;
import com.github.shyiko.mysql.binlog.event.Event;
import com.github.shyiko.mysql.binlog.event.EventData;
import com.github.shyiko.mysql.binlog.event.QueryEventData;
import com.github.shyiko.mysql.binlog.event.TableMapEventData;
import com.github.shyiko.mysql.binlog.event.UpdateRowsEventData;
import com.github.shyiko.mysql.binlog.event.WriteRowsEventData;

/** 
* 描述：
* @author zhengjinlei 
* @version 2018年1月30日 下午4:44:16 
*/
public class BinlogTest {

	public static void main(String[] args) throws IOException {
		BinaryLogClient client = new BinaryLogClient("127.0.0.2", 3306, "root", "zjlzjl");
		client.registerEventListener(new BinaryLogClient.EventListener() {
			@Override
			public void onEvent(Event e) {
				EventData data = e.getData();
				if(data instanceof QueryEventData){
					System.out.println(((QueryEventData)data).getSql());
				}else if(data instanceof TableMapEventData){
					System.out.println("收到数据库DDL操作："+((TableMapEventData)data).getTable());
				}else if(data instanceof UpdateRowsEventData){
					System.out.println("收到数据库DML操作update："+data.toString());
				}else if(data instanceof WriteRowsEventData){
					System.out.println("收到数据库DML操作insert："+data.toString());
				}else if(data instanceof DeleteRowsEventData){
					System.out.println("收到数据库DML操作delete："+data.toString());
				}
			}
		});
		client.connect();
	}

}

