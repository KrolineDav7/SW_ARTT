package sw.persistence;

import sw.model.Town;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jairsh
 */
public interface DaoTown extends JpaRepository<Town, Integer> 
{
    public Town getByName(String nae);
}
