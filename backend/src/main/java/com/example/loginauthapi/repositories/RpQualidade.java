package demo.sa304.Repository;

import demo.sa304.Entity.Erro;
import demo.sa304.Entity.Qualidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RpQualidade extends JpaRepository<Qualidade,Long> {
}
