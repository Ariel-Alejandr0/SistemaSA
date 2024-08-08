package demo.sa304.Controllers;

import demo.sa304.DTO.ErroDTO;
import demo.sa304.DTO.ProdutoDTO;
import demo.sa304.DTO.QualidadeDTO;
import demo.sa304.Service.QualidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/qualidade/")
public class QualidadeController {
    @Autowired
    private QualidadeService qualidadeService;

    @GetMapping("get")
    public List<QualidadeDTO> getAllerro(){
        return qualidadeService.listar();
    }

    @PostMapping
    public void incluirProduto(@RequestBody QualidadeDTO qualidadeDTO) {
        qualidadeService.incluir(qualidadeDTO);
    }

    @PutMapping("put")
    public QualidadeDTO alterar(@RequestBody QualidadeDTO qualidadeDTO) {
        return qualidadeService.alterar(qualidadeDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id ) {
        qualidadeService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
