package demo.sa304.Controllers;


import demo.sa304.DTO.EstoqueDTO;
import demo.sa304.DTO.ProdutoDTO;
import demo.sa304.Service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque/")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping("get")
    public List<EstoqueDTO> getAllEstoque(){
        return estoqueService.listar();
    }

    @PostMapping("post")
    public void incluir(@RequestBody EstoqueDTO estoqueDTO) {
        estoqueService.incluir(estoqueDTO);
    }

    @PutMapping("put")
    public EstoqueDTO alterar(@RequestBody EstoqueDTO estoqueDTO) {
        return estoqueService.alterar(estoqueDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable("id") Long id ) {
        estoqueService.excluir(id);
        return ResponseEntity.noContent().build();
    }



}
