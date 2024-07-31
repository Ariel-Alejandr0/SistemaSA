package com.example.loginauthapi.service.mm.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class MachineController {

	private final SimpMessagingTemplate messagingTemplate;
	private final AtomicInteger pieceCounter = new AtomicInteger(0);

	@Autowired
	public MachineController(SimpMessagingTemplate messagingTemplate) {
		this.messagingTemplate = messagingTemplate;
	}
	
	// Método para agendar o envio de mensagens a cada 3 segundos com atraso inicial de 5 segundos
	@Scheduled(initialDelay = 5000, fixedRate = 3000)
	public void sendPeriodicMessages() {
		int pieceNumber = pieceCounter.incrementAndGet();
		System.out.println(pieceNumber);
		Machine greeting = new Machine(pieceNumber);
		messagingTemplate.convertAndSend("/topic/greetings", greeting);
	}
}
