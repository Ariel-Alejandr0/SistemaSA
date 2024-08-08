package demo.sa304.Repository;

import demo.sa304.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RpProdutos extends JpaRepository<Produto, Long> {

}
