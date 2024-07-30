package demo.sa304.Service;

import demo.sa304.DTO.EstoqueDTO;
import demo.sa304.DTO.ProdutoDTO;
import demo.sa304.Entity.Estoque_Produto;
import demo.sa304.Entity.Produto;
import demo.sa304.Repository.RpEstoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {
    @Autowired
    private RpEstoque rpEstoque;

    public List<EstoqueDTO> listar() {
        List<Estoque_Produto> getAllestoque = rpEstoque.findAll();
        return  getAllestoque.stream().map(EstoqueDTO::new).toList();
    }

    public void incluir(EstoqueDTO estoque) {
        Estoque_Produto Incluirestoque = new Estoque_Produto(estoque);
        rpEstoque.save(Incluirestoque);
    }

    public EstoqueDTO alterar(EstoqueDTO estoqueDTO) {
        Estoque_Produto Alterar = new Estoque_Produto(estoqueDTO);
        return new EstoqueDTO(rpEstoque.save(Alterar));
    }

    public void excluir(Long id) {
        Estoque_Produto estoque = rpEstoque.findById(id).get();
        rpEstoque.delete(estoque);
    }
}
