package com.sougho.netty.chat;

import java.util.ArrayList;
import java.util.List;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

	private static final List<Channel> channels = new ArrayList<Channel>();

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) {
		
		Channel incoming = ctx.channel();
		System.out.println("Added: " + incoming.remoteAddress());
		for (Channel channel : channels) {
			channel.write("[SERVER]" + incoming.remoteAddress() + "had joined\r\n");
		}
		channels.add(incoming);
	}
	
	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) {
		Channel incoming = ctx.channel();
		System.out.println("Removed: " + incoming.remoteAddress());
		for (Channel channel : channels) {
			channel.write("[SERVER]" + incoming.remoteAddress() + "had left\r\n");
		}
		channels.remove(incoming);
	}
	
	@Override
	protected void channelRead0(ChannelHandlerContext paramChannelHandlerContext, String paramI) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Read: " + paramI);
		Channel incoming = paramChannelHandlerContext.channel();
		for (Channel channel : channels ) {
			if (channel != incoming) {
				channel.write("[" + incoming.remoteAddress() + "]" + paramI + "\r\n");
				channel.flush();
			}
		}
		System.out.println(paramI); 
	}

}
