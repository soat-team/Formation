package fr.soat.interco.web.service;

import fr.soat.interco.bean.Agent;
import fr.soat.interco.bean.BienImmobilier;
import fr.soat.interco.bean.Client;
import fr.soat.interco.bean.Visite;
import fr.soat.interco.dao.VisiteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe implementation de service.
 */
@Service
public class VisiteServiceImpl implements VisiteService {

    @Autowired
    private VisiteDao visiteDao;

    @Override
    public Visite findVisitById(Integer id) {
        return visiteDao.findOne(id);
    }

    @Override
    public Iterable<Visite> findAll() {
        return visiteDao.findAll();
    }

    @Override
    public Client findClientForVisit(Integer id) {
        return visiteDao.findClientForVisit(id);
    }

    @Override
    public Agent findAgentForVisit(Integer id) {
        return visiteDao.findAgentForVisit(id);
    }

    @Override
    public BienImmobilier findBienImmoForVisit(Integer id) {
        return visiteDao.findBienImmoForVisit(id);
    }
}
