package hr.inovatrend.carservicelora.manager;

import hr.inovatrend.carservicelora.entity.User;

import java.util.List;

public interface UserManager {

    User createUser(User user);

    List<User> getAll();

    User getUser(Long id);

    void deleteById(Long id);

}
