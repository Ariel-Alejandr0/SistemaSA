package com.example.loginauthapi.service.mm.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		// Configura o broker de mensagens com destino prefixado "/topic"
		config.enableSimpleBroker("/topic");
		// Define o prefixo de destino da aplicação "/app"
		config.setApplicationDestinationPrefixes("/app");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// Registra o endpoint STOMP em "/gs-guide-websocket"
		registry.addEndpoint("/gs-guide-websocket").withSockJS();

	}
}
