package com.example.loginauthapi.service.mm.websocket;

public class Machine {

	private int content;

	// Construtor padrão
	public Machine() {
	}

	// Construtor que inicializa o conteúdo
	public Machine(int content) {
		this.content = content;
	}

	// Getter para o conteúdo
	public int getContent() {
		return content;
	}
}
