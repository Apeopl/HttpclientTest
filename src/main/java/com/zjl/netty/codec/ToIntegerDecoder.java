package com.zjl.netty.codec;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

/** 
* 描述：入站解码
* @author zhengjinlei 
* @version 2017年8月11日 上午9:51:54 
*/
public class ToIntegerDecoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		if(in.readableBytes()>=4){
			out.add(in.readInt());
		}
	}

}

