package com.example.loginauthapi.service.ru;


import com.example.loginauthapi.domain.user.Produto;
import com.example.loginauthapi.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProdutoService {

    private ProdutoRepository repository;

    public void criarProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setMaterial(produtoDTO.getMaterial());
        produto.setCor(produtoDTO.getCor());
        produto.setTamanho(produtoDTO.getTamanho());
        produto.setTipo(produtoDTO.getTipo());
        repository.save(produto);
    }
    public void updateProdutoDTO(ProdutoDTO produtoDTO){
        Produto produto = repository.findById(produtoDTO.getId()).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produto.setMaterial(produtoDTO.getMaterial());
        produto.setCor(produtoDTO.getCor());
        produto.setTamanho(produtoDTO.getTamanho());
        produto.setTipo(produtoDTO.getTipo());
        repository.save(produto);
    }
}
