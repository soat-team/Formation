package fr.soat.interco.web.service;

import fr.soat.interco.bean.Agent;
import fr.soat.interco.bean.Client;
import fr.soat.interco.bean.User;
import fr.soat.interco.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

/**
 * User service.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Agent authenticateAgent(String login, String password) {
        return userDao.authenticateAgent(login,password);
    }

    @Override
    public Client authenticateClient(String login, String password) {
        return userDao.authenticateClient(login, password);
    }

    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }
}
