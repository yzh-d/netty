package com.uv.server;
/*
 * @author 闫志行
 * 处理服务端接收的数据
 */

import com.uv.entity.User;
import com.uv.protocol.RpcRequest;
import com.uv.protocol.RpcResponse;
import com.uv.service.UserService;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

import static com.uv.protocol.RpcResponse.type1;
import static com.uv.protocol.RpcResponse.type2;

@Component
public class ServerHandler extends ChannelInboundHandlerAdapter{

    @Resource
    private UserService userService;

    //接受client发送的消息
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        RpcRequest request = (RpcRequest) msg;
        System.out.println("接收到客户端信息:" + request.getType());
        String content = request.getContent();
        String type = request.getType();
        //返回的数据结构
        if (type1.equals(type)) {
            List<User> users = userService.selectAll();
            users.forEach(user->
                    {
                        RpcResponse response = new RpcResponse();
                        response.setId(UUID.randomUUID().toString());
                        response.setContent(user.toString());
                        response.setStatus(1);
                        ctx.writeAndFlush(response);
                    }
            );
        } else if(type2.equals(type)) {
            userService.insertContent(content);
        }
    }

    //通知处理器最后的channelRead()是当前批处理中的最后一条消息时调用
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("服务端接收数据完毕..");
        ctx.flush();
    }

    //读操作时捕获到异常时调用
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }

    //客户端去和服务端连接成功时触发
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        ctx.writeAndFlush("hello client");
    }
}
