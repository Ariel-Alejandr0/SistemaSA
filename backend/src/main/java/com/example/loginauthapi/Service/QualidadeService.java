package demo.sa304.Service;

import demo.sa304.DTO.ProdutoDTO;
import demo.sa304.DTO.QualidadeDTO;
import demo.sa304.Entity.Produto;
import demo.sa304.Entity.Qualidade;
import demo.sa304.Repository.RpQualidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualidadeService {

    @Autowired
    private RpQualidade rpQualidade;

    public List<QualidadeDTO> listar() {
        List<Qualidade> getAllqualidade   = rpQualidade.findAll();
        return getAllqualidade.stream().map(QualidadeDTO::new).toList();
    }

    public void incluir(QualidadeDTO qualidade) {
        Qualidade Incluir = new Qualidade(qualidade);
        rpQualidade.save(Incluir);
    }

    public QualidadeDTO alterar(QualidadeDTO qualidadeDTO) {
        Qualidade Alterar = new Qualidade(qualidadeDTO);
        return new QualidadeDTO(rpQualidade.save(Alterar));
    }

    public void excluir(Long id) {
        Qualidade qualidade = rpQualidade.findById(id).get();
        rpQualidade.delete(qualidade);
    }
}
