package com.uv;

import com.uv.server.NettyServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * <uv> [2018/10/13 19:52]
 */
@SpringBootApplication
@MapperScan("com.uv.mapper")
public class Server implements CommandLineRunner {
    @Resource
    private NettyServer nettyServer;
    public static void main(String[] args) throws Exception {
        //启动server服务
        SpringApplication.run(Server.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        nettyServer.bind(8080);
    }
}
