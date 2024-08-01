package com.example.loginauthapi.service.geral;

import com.example.loginauthapi.domain.user.*;
import com.example.loginauthapi.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final CpfRepository cpfRepository;
    private final EnderecoRepository enderecoRepository;
    private final PessoaRepository pessoaRepository;
    private final UsuarioRepository usuarioRepository;
    private final CnpjRepository cnpjRepository;

    public void inserirUsuarioGeral(UsuarioDTO usuarioDTO) {
        // Salvar Endereço
        Endereco endereco = Endereco.builder()
                .cep(usuarioDTO.getPessoa().getEndereco().getCep())
                .logradouro(usuarioDTO.getPessoa().getEndereco().getLogradouro())
                .numero(usuarioDTO.getPessoa().getEndereco().getNumero())
                .complemento(usuarioDTO.getPessoa().getEndereco().getComplemento())
                .bairro(usuarioDTO.getPessoa().getEndereco().getBairro())
                .cidade(usuarioDTO.getPessoa().getEndereco().getCidade())
                .estado(usuarioDTO.getPessoa().getEndereco().getEstado())
                .build();
        enderecoRepository.save(endereco);

        // Salvar Pessoa
        Pessoa pessoa = Pessoa.builder()
                .nome(usuarioDTO.getPessoa().getNome())
                .telefone(usuarioDTO.getPessoa().getTelefone())
                .endereco(endereco)
                .tipo(usuarioDTO.getPessoa().getTipo())
                .obs(usuarioDTO.getPessoa().getObs())
                .build();
        pessoaRepository.save(pessoa);

        if (usuarioDTO.getPessoa().getCpfDTO() != null) {
            Cpf cpf = Cpf.builder()
                    .cpf(usuarioDTO.getPessoa().getCpfDTO().getCpf())
                    .dataNascimento(usuarioDTO.getPessoa().getCpfDTO().getDataNascimento())
                    .genero(usuarioDTO.getPessoa().getCpfDTO().getGenero())
                    .pessoa(pessoa)
                    .build();
            cpfRepository.save(cpf);
        } else if (usuarioDTO.getPessoa().getCnpjDTO() != null) {
            Cnpj cnpj = Cnpj.builder()
                    .cnpj(usuarioDTO.getPessoa().getCnpjDTO().getCnpj())
                    .nomeFantasia(usuarioDTO.getPessoa().getCnpjDTO().getNomeFantasia())
                    .tipo(usuarioDTO.getPessoa().getCnpjDTO().getTipo())
                    .iM(usuarioDTO.getPessoa().getCnpjDTO().getIM())
                    .iE(usuarioDTO.getPessoa().getCnpjDTO().getIE())
                    .ramoAtividade(usuarioDTO.getPessoa().getCnpjDTO().getRamoAtividade())
                    .pessoa(pessoa)
                    .build();
            cnpjRepository.save(cnpj);
        }

        // Salvar Usuario
        Usuario usuario = Usuario.builder()
                .pessoa(pessoa)
                .dataCadastro(usuarioDTO.getDataCadastro())
                .papel(usuarioDTO.getPapel())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .build();
        usuarioRepository.save(usuario);
    }
}
