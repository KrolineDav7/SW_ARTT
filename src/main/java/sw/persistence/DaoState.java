package sw.persistence;

import sw.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jairsh
 */
public interface DaoState extends JpaRepository<State, Integer> 
{
  public State getByName(String name);
}
