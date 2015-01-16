package sw.persistence;

import sw.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jairsh
 */
public interface DaoModel extends JpaRepository<Model, Integer> 
{
    public Model getByName(String name);

}
