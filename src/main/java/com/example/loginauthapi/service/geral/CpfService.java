package com.example.loginauthapi.service.geral;



import com.example.loginauthapi.domain.user.Cpf;
import com.example.loginauthapi.domain.user.Endereco;
import com.example.loginauthapi.domain.user.Pessoa;
import com.example.loginauthapi.domain.user.Usuario;
import com.example.loginauthapi.repositories.CpfRepository;
import com.example.loginauthapi.repositories.EnderecoRepository;
import com.example.loginauthapi.repositories.PessoaRepository;
import com.example.loginauthapi.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
public class CpfService {

    private final CpfRepository cpfRepository;
    private final EnderecoRepository enderecoRepository;
    private final PessoaRepository pessoaRepository;
    private final UsuarioRepository usuarioRepository;

    public void inserir(CpfDTO cpfDTO) {
        Endereco endereco = Endereco.builder()
                .cep(cpfDTO.getEndereco().getCep())
                .logradouro(cpfDTO.getEndereco().getLogradouro())
                .numero(cpfDTO.getEndereco().getNumero())
                .complemento(cpfDTO.getEndereco().getComplemento())
                .bairro(cpfDTO.getEndereco().getBairro())
                .cidade(cpfDTO.getEndereco().getCidade())
                .estado(cpfDTO.getEndereco().getEstado())
                .build();
        enderecoRepository.save(endereco);

        Pessoa pessoa = Pessoa.builder()
                .nome(cpfDTO.getNome())
                .telefone(cpfDTO.getTelefone())
                .endereco(endereco)
                .tipo(cpfDTO.getTipo())
                .obs(cpfDTO.getObs())
                .build();
        pessoaRepository.save(pessoa);

        Usuario usuario = Usuario.builder()
                .nome(cpfDTO.getNomeUsuario())
                .email(cpfDTO.getEmailUsuario())
                .idPapel(cpfDTO.getIdPapelUsuario())
                .senha(cpfDTO.getSenhaUsuario())
                .pessoa(pessoa)
                .dataCadastro(Instant.now())
                .build();
        usuarioRepository.save(usuario);

        Cpf cpf = Cpf.builder()
                .cpf(cpfDTO.getCpf())
                .dataNascimento(cpfDTO.getDataNascimento())
                .pessoa(pessoa)
                .build();
        cpfRepository.save(cpf);

    }
}
