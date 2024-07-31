package com.example.loginauthapi.service.geral;



import com.example.loginauthapi.domain.user.Cpf;
import com.example.loginauthapi.domain.user.Endereco;
import com.example.loginauthapi.domain.user.Pessoa;
import com.example.loginauthapi.repositories.CpfRepository;
import com.example.loginauthapi.repositories.EnderecoRepository;
import com.example.loginauthapi.repositories.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CpfService {

    private final CpfRepository cpfRepository;
    private final EnderecoRepository enderecoRepository;
    private final PessoaRepository pessoaRepository;

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

        Cpf cpf = Cpf.builder()
                .cpf(cpfDTO.getCpf())
                .dataNascimento(cpfDTO.getDataNascimento())
                .pessoa(pessoa)
                .build();
        cpfRepository.save(cpf);
    }
}
