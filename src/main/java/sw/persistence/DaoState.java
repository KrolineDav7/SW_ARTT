package sw.persistence;

import java.util.List;
import sw.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import sw.model.Country;

/**
 *
 * @author jairsh
 */
public interface DaoState extends JpaRepository<State, Integer> 
{
  public State getByName(String name);
  public List<State> findByCountry(Country country);
}
