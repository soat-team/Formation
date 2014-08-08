package fr.soat.interco.web.service;

import fr.soat.interco.bean.Visite;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by formation on 08/08/14.
 */
@Transactional
public interface BienImmoService {

    /**
     * Retrieves all the visits for a client.
     * @param id
     * @return
     */
    public List<Visite> findVisitsForBienImmo(Integer id);
}
