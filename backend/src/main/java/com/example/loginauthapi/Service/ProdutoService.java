package demo.sa304.Service;

import demo.sa304.DTO.ProdutoDTO;
import demo.sa304.Entity.Produto;
import demo.sa304.Repository.RpProdutos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private RpProdutos rpProdutos;

    public List<ProdutoDTO> listarProduto() {
       List<Produto> getAllprodutos = rpProdutos.findAll();
       return  getAllprodutos.stream().map(ProdutoDTO::new).toList();
    }

    public void incluir(ProdutoDTO produto) {
        Produto Incluirproduto = new Produto(produto);
        rpProdutos.save(Incluirproduto);
    }

    public ProdutoDTO alterar(ProdutoDTO produto1) {
        Produto Alterarproduto = new Produto(produto1);
        return new  ProdutoDTO(rpProdutos.save(Alterarproduto));
    }

    public void excluir(Long id) {
        Produto produto = rpProdutos.findById(id).get();
        rpProdutos.delete(produto);
    }

    public  ProdutoDTO buscarPorId(Long id) {
        return new ProdutoDTO(rpProdutos.findById(id).get());
    }

}
