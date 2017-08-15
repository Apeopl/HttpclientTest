package com.zjl.netty;

import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/** 
* 描述：
* @author zhengjinlei 
* @version 2017年8月1日 下午4:25:59 
*/
public class EchoServer {
	private final int port;
	public EchoServer(int port){
		this.port = port;
	}
	public static void main(String[] args) throws Exception{
		if(args.length != 1){
			System.err.println("Usage:"+EchoServer.class.getSimpleName()+"<port>");
			return;
		}
		int port = Integer.parseInt(args[0]);
		new EchoServer(port).start();
	}
	public void start() throws Exception{
		NioEventLoopGroup group = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(group)
			.channel(NioServerSocketChannel.class)
			.localAddress(new InetSocketAddress(port))
			.childHandler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new EchoServerHandler());
				}
				
			});
			ChannelFuture f = b.bind().sync();
			System.out.println(EchoServer.class.getName()+"started and listen on ");
			f.channel().closeFuture().sync();
		} finally {
			group.shutdownGracefully().sync();
		}
	}
}

