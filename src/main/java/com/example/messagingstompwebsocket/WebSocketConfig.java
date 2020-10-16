package com.example.messagingstompwebsocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/app");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// registry.addEndpoint("/gs-guide-websocket").withSockJS();
		// registry.addEndpoint("gs-guide-websocket").addInterceptors(new HttpSessionHandshakeInterceptor()).setAllowedOrigins("http://222.1.1.155:8080");
		registry.addEndpoint("gs-guide-websocket").addInterceptors(new HttpSessionHandshakeInterceptor()).setAllowedOrigins("*");
	}
	
    // @Bean
    // public ServerEndpointExporter serverEndpointExporter() {
    //     return new ServerEndpointExporter();
    // }

}
