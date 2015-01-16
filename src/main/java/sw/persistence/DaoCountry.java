package sw.persistence;

import sw.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoCountry extends JpaRepository<Country, Integer>  {
   public Country getByName(String name);
}
