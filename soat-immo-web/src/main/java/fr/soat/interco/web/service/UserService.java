package fr.soat.interco.web.service;

import fr.soat.interco.bean.Agent;
import fr.soat.interco.bean.Client;
import fr.soat.interco.bean.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * User service.
 */
@Transactional
public interface UserService {
    /**
     *
     * @param login
     * @param password
     * @return
     */
    @Query("from Agent a where a.user.login = ?1 and a.user.password = ?2")
    public Agent authenticateAgent(String login, String password);

    /**
     *
     * @param login
     * @param password
     * @return
     */
    @Query("from Client a where a.user.login = ?1 and a.user.password = ?2")
    public Client authenticateClient(String login, String password);


    /**
     *
     * @param user
     * @return
     */
    public User saveUser(User user);
}
