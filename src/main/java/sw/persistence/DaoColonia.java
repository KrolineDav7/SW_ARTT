package sw.persistence;

import sw.model.Colonia;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jairsh
 */
public interface DaoColonia extends JpaRepository<Colonia, Integer> 
{
  public Colonia obtenerXNombre(String nombre);
}