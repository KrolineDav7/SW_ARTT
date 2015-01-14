package sw.persistence;

import sw.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoPais extends JpaRepository<Pais, Integer>  {
  public Pais getByName(String name);
}
