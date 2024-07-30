package demo.sa304.Service;

import demo.sa304.DTO.ErroDTO;
import demo.sa304.DTO.EstoqueDTO;
import demo.sa304.DTO.ProdutoDTO;
import demo.sa304.Entity.Erro;
import demo.sa304.Entity.Estoque_Produto;
import demo.sa304.Entity.Produto;
import demo.sa304.Repository.RpErro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ErroService {

    @Autowired
    private RpErro rperro;

    public List<ErroDTO> listar() {
        List<Erro> getAllerro   = rperro.findAll();
        return getAllerro.stream().map(ErroDTO::new).toList();
    }

    public void incluir(ErroDTO erro) {
        Erro Incluir = new Erro(erro);
        rperro.save(Incluir);
    }

    public ErroDTO alterar(ErroDTO erroDTO) {
        Erro Alterarproduto = new Erro(erroDTO);
        return new ErroDTO(rperro.save(Alterarproduto));
    }


    public void excluir(Long id) {
        Erro erro = rperro.findById(id).get();
        rperro.delete(erro);
    }
}
