package com.example.messagingstompwebsocket;

// import com.example.client.StompClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
// @SpringBootApplication
// public class MessagingStompWebsocketApplication {
public class MessagingStompWebsocketApplication extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(MessagingStompWebsocketApplication.class, args);
		// new TesraController().stompClient();
	}
    // @Override  
    // public void customize(ConfigurableEmbeddedServletContainer container) {
    //     //指定项目名称
    //     container.setContextPath("/demo");
    //     //指定端口地址
    //     container.setPort(8090);  
    // }
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MessagingStompWebsocketApplication.class);
	}
}
