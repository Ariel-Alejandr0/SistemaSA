package com.example.loginauthapi.domain.user;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "machine")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "machine")
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_machine")
    private Long id_machine;

    @Column(name = "name")
    private String name;

    @Column(name = "id_tipo_maquina")
    private String idTipoMaquina;

    @Column(name = "data_instalacao")
    private Date dataInstalacao;

    @Column(name = "setor")
    private String setor;

    @Column(name = "ultima_manutencao")
    private Date ultimaManutencao;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Machine(String name, String idTipoMaquina, Date dataInstalacao, String setor, Usuario usuario, Date ultimaManutencao) {
        this.name = name;
        this.idTipoMaquina = idTipoMaquina;
        this.dataInstalacao = dataInstalacao;
        this.setor = setor;
        this.usuario = usuario;
        this.ultimaManutencao = ultimaManutencao;
    }
}
