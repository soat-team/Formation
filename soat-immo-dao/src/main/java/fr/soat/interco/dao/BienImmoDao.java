package fr.soat.interco.dao;

import fr.soat.interco.bean.BienImmobilier;
import fr.soat.interco.bean.Visite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Dao interface to BienImmo
 */
public interface BienImmoDao extends CrudRepository<BienImmobilier, Integer> {

    /**
     * Retrieves all the visits for a client.
     * @param id
     * @return
     */
    @Query("select visits from BienImmobilier c where c.id = ?1")
    public List<Visite> findVisitsForBienImmo(Integer id);
}
