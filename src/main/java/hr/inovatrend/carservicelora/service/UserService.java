package hr.inovatrend.carservicelora.service;

import hr.inovatrend.carservicelora.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    List<User> getAll();

    User getUser(Long id);

}
