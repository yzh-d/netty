package com.uv;
import com.uv.client.NettyClient;
import com.uv.protocol.RpcRequest;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.UUID;
/**
 * @author zhihang.yzh
 */
public class Client {
    public static void main(String[] args) throws Exception {
        NettyClient client = new NettyClient("127.0.0.1", 8080);
        //启动client服务
        client.start();
        Channel channel = client.getChannel();
        //消息体
        System.out.println("请输入请求类型(查询 or 写入) :");
        Scanner scanner1 = new Scanner(System.in);

        while (scanner1.hasNext()){
            String msg = scanner1.nextLine();
            if ("查询".equals(msg)) {
                RpcRequest request = new RpcRequest();
                request.setId(UUID.randomUUID().toString());
                request.setType(msg);
                //channel对象可保存在map中，供其它地方发送消息
                channel.writeAndFlush(request);
            } else if ("写入".equals(msg)){
                System.out.println("请输入要写入的数据 :");
                String msg1 = scanner1.nextLine();
                RpcRequest request = new RpcRequest();
                request.setId(UUID.randomUUID().toString());
                request.setContent(msg1);
                request.setType(msg);
                //channel对象可保存在map中，供其它地方发送消息
                channel.writeAndFlush(request);
            }
        }
    }
}
