package fr.soat.interco.web.service;

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
}
