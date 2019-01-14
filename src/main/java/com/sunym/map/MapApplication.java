package com.sunym.map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sunym.map.config.MessageListener;

@SpringBootApplication
public class MapApplication {
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(MapApplication.class);
		// 注册监听器，添加properties配置
		application.addListeners(new MessageListener("config/message.properties"));
		application.run(args);
	}
}
