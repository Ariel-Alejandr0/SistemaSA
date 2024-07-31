package com.example.loginauthapi.service.luis;


import com.example.loginauthapi.domain.user.EstoqueInsumos;
import com.example.loginauthapi.repositories.EstoqueInsumosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;


@AllArgsConstructor
@Service
public class EstoqueInsumosService {

    private EstoqueInsumosRepository repository;

    public void adicionarInsumos(EstoqueInsumosDTO estoqueInsumosDTO){
        EstoqueInsumos estoqueInsumos = new EstoqueInsumos();
        estoqueInsumos.setNome(estoqueInsumosDTO.getNome());
        estoqueInsumos.setCor(estoqueInsumosDTO.getCor());
        estoqueInsumos.setPreco(estoqueInsumosDTO.getPreco());
        estoqueInsumos.setUM(estoqueInsumosDTO.getUM());
        estoqueInsumos.setQuantidade(estoqueInsumosDTO.getQuantidade());
        estoqueInsumos.setTipo(estoqueInsumosDTO.getTipo());

        //salvar insumo no banco
        repository.save(estoqueInsumos);
    }

    public void updateEstoqueInsumos(EstoqueInsumosDTO estoqueInsumosDTO){
        EstoqueInsumos estoqueInsumos = repository.findById(estoqueInsumosDTO.getId()).orElseThrow(() -> new RuntimeException("Insumo não encontrado"));
        estoqueInsumos.setNome(estoqueInsumosDTO.getNome());
        estoqueInsumos.setCor(estoqueInsumosDTO.getCor());
        estoqueInsumos.setPreco(estoqueInsumosDTO.getPreco());
        estoqueInsumos.setUM(estoqueInsumosDTO.getUM());
        estoqueInsumos.setQuantidade(estoqueInsumosDTO.getQuantidade());
        estoqueInsumos.setTipo(estoqueInsumosDTO.getTipo());

        //atualizar insumo no banco
        repository.save(estoqueInsumos);
    }

    public EstoqueInsumos findById(Long id) {
        Optional<EstoqueInsumos> result = repository.findById(id);

        EstoqueInsumos estoqueInsumos = null;

        if (result.isPresent()) {
            estoqueInsumos = result.get();
        }
        else{
            throw new RuntimeException("Insumo não encontrado");
        }

        return estoqueInsumos;
    }

    public Optional<EstoqueInsumosDTO> verificarDisponibilidadeInsumo(String nome, String cor, String tipo) {
        return repository.findByNomeAndCorAndTipo(nome, cor, tipo);
    }
}
