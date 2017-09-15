package com.sovanm.websocketdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@EnableWebSocketMessageBroker
@Configuration
public class WebSocketConfiguration extends AbstractWebSocketMessageBrokerConfigurer{
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/topic");									// End point this application will send message in client,
		registry.setApplicationDestinationPrefixes("/app");						// End point client will send message to server.
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/chat");											// End point through which a connect via web socket with this application.
		registry.addEndpoint("/chat").withSockJS();								// Same as above but with SockJS
	}
}
