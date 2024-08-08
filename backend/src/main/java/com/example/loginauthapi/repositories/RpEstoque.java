package demo.sa304.Repository;

import demo.sa304.Entity.Estoque_Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RpEstoque extends JpaRepository<Estoque_Produto,Long> {

}
