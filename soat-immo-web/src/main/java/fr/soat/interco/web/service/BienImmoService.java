package fr.soat.interco.web.service;

import fr.soat.interco.bean.BienImmobilier;
import fr.soat.interco.bean.TypeImmo;
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
    public List<Visite> findVisitsForBienImmo(Long id);


    /**
     * Returns a list of BienImmo by type.
     * @param typeImmo
     * @return
     */
    public List<BienImmobilier> findImmoByType(TypeImmo typeImmo);


    /**
     *
     * @param bienImmobilier
     * @return
     */
    public BienImmobilier saveBienImmo(BienImmobilier bienImmobilier);


    /**
     *
     * @return
     */
    public Iterable<BienImmobilier> findAllBienImmo();

    /**
     *
     * @param bi
     */
    public void deleteBienImmo(BienImmobilier bi);

    /**
     *
     * @param adresse
     * @return
     */
    public List<BienImmobilier> findBienImmoByAdresse(String adresse);

    /**
     *
     * @param idbienImmobiler
     * @return
     */
    public BienImmobilier findBienImmoById(Long idbienImmobiler);
}
