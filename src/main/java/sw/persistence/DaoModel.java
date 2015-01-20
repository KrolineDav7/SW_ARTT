package sw.persistence;

import java.util.List;
import sw.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import sw.model.Suburb;

/**
 *
 * @author jairsh
 */
public interface DaoModel extends JpaRepository<Model, Integer> 
{
    public Model getByName(String name);
    public List<Model> getBySuburb(Suburb suburb);
}
