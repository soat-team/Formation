package fr.soat.interco.web.service;

import fr.soat.interco.bean.BienImmobilier;
import fr.soat.interco.bean.TypeImmo;
import fr.soat.interco.bean.Visite;
import fr.soat.interco.dao.BienImmoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by formation on 08/08/14.
 */
@Service
public class BienImmoServiceImpl implements BienImmoService {

    @Autowired
    private BienImmoDao bienImmoDao;

    @Override
    public List<Visite> findVisitsForBienImmo(Integer id) {
        return bienImmoDao.findVisitsForBienImmo(id);
    }

    @Override
    public List<BienImmobilier> findImmoByType(TypeImmo typeImmo) {
        return bienImmoDao.findBienImmoByType(typeImmo);
    }


    @Override
    public BienImmobilier saveBienImmo(BienImmobilier bienImmobilier) {
        return bienImmoDao.save(bienImmobilier);
    }

    @Override
    public Iterable<BienImmobilier> findAllBienImmo() {
        return bienImmoDao.findAll();
    }

    @Override
    public void deleteBienImmo(BienImmobilier bi) {
        bienImmoDao.delete(bi);
    }


    @Override
    public List<BienImmobilier> findBienImmoByAdresse(String adresse) {
        return bienImmoDao.findBienImmoByAdresse(adresse);
    }

    @Override
    public BienImmobilier findBienImmoById(Integer idbienImmobiler) {
        return bienImmoDao.findOne(idbienImmobiler);
    }
}
