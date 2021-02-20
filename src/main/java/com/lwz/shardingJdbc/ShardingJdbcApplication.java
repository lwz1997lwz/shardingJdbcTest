package com.lwz.shardingJdbc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.lwz.shardingJdbc"})
public class ShardingJdbcApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("开始启动");
    }
}
