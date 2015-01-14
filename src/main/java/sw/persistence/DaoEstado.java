package sw.persistence;

import sw.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jairsh
 */
public interface DaoEstado extends JpaRepository<Estado, Integer> 
{
}
