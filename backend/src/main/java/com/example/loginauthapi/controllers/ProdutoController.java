package demo.sa304.Controllers;



import demo.sa304.DTO.ProdutoDTO;
import demo.sa304.Entity.Produto;
import demo.sa304.Repository.RpProdutos;
import demo.sa304.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto/")
public class ProdutoController {
@Autowired
    private ProdutoService produtoService;

@GetMapping("get")
    public List<ProdutoDTO> getAllprodutos() {
    return  produtoService.listarProduto();
}



@PostMapping("post")
public void incluirProduto(@RequestBody ProdutoDTO produtoDTO) {
    produtoService.incluir(produtoDTO);
}

@PutMapping("put")
public ProdutoDTO alterar(@RequestBody ProdutoDTO produtoDTO) {
    return produtoService.alterar(produtoDTO);
}


@DeleteMapping("{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable("id") Long id ) {
    produtoService.excluir(id);
    return ResponseEntity.noContent().build();
}

}
