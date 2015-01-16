package sw.persistence;

import sw.model.Suburb;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jairsh
 */
public interface DaoSuburb extends JpaRepository<Suburb, Integer> 
{
   public Suburb getByName(String name);
}