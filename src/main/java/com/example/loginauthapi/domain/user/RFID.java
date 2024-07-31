package com.example.loginauthapi.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rfid")
public class RFID {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_RFID")
    private Long Id_RFID;

    @OneToOne
    @JoinColumn(name = "id_localizacao")
    private Localizacao id_localizacao;

    @Column(name = "data_ativacao")
    private Date data_ativacao;

    @Column(name = "data_atualizacao")
    private Date data_atualizacao;

    @Column(name = "tag_leitura")
    private String tag_leitura;

}
