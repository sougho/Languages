package com.sougho.netty.chat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class ChatServer {

	private int port;
	
	public ChatServer(int port) {
		this.port = port;
		
	}
	
	public void run() throws Exception 
	{
		System.out.println("Running");
		EventLoopGroup controllerGrp = new NioEventLoopGroup();
		EventLoopGroup workerGrp = new NioEventLoopGroup();
		try {
			ServerBootstrap bootstrap = new ServerBootstrap()
					.group(controllerGrp, workerGrp)
					.channel(NioServerSocketChannel.class)
					.childHandler(new ChatserverInitializer())
					;
			bootstrap.bind(port).sync().channel().closeFuture().sync();
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			controllerGrp.shutdownGracefully();
			workerGrp.shutdownGracefully();
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("Starting Chat Server");
		new ChatServer(8000).run();
	}
}
