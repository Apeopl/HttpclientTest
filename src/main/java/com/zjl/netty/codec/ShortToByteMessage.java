package com.zjl.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/** 
* 描述：出站编码
* @author zhengjinlei 
* @version 2017年8月11日 上午10:03:41 
*/
public class ShortToByteMessage extends MessageToByteEncoder<Short> {

	@Override
	protected void encode(ChannelHandlerContext ctx, Short msg, ByteBuf out) throws Exception {
		out.writeShort(msg);
	}

}

