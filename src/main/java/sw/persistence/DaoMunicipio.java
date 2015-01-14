package sw.persistence;

import sw.model.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jairsh
 */
public interface DaoMunicipio extends JpaRepository<Municipio, Integer> 
{
    public Municipio obtenerXNombre(String nombre);
}
