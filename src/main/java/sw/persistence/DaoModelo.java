package sw.persistence;

import sw.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jairsh
 */
public interface DaoModelo extends JpaRepository<Modelo, Integer> 
{
    //public Modelo obtenerXNombre(String nombre);

}
