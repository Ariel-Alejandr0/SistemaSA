package demo.sa304.Controllers;

import demo.sa304.DTO.ErroDTO;
import demo.sa304.DTO.EstoqueDTO;
import demo.sa304.Service.ErroService;
import demo.sa304.Service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/erro/")
public class ErroController {

    @Autowired
    private ErroService erroService;

    @GetMapping("get")
    public List<ErroDTO> getAllerro(){
        return erroService.listar();
    }

    @PostMapping("post")
    public void incluir(@RequestBody ErroDTO erroDTO) {
        erroService.incluir(erroDTO);
    }

    @PutMapping("put")
    public ErroDTO alterar(@RequestBody ErroDTO erroDTO) {
        return erroService.alterar(erroDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id ) {
        erroService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
