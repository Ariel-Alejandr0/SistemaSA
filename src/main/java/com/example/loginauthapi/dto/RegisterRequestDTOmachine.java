package com.example.loginauthapi.dto;

import java.util.Date;

public record RegisterRequestDTOmachine(String name, String idTipoMaquina, Date dataInstalacao, String setor, Long idUsuario, Date ultimaManutencao) {
}
