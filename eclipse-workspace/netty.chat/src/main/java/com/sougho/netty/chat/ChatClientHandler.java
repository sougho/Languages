package com.sougho.netty.chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;



public class ChatClientHandler extends SimpleChannelInboundHandler<String> {

	@Override
	protected void channelRead0(ChannelHandlerContext paramChannelHandlerContext, String msg) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(msg);
	}

}
