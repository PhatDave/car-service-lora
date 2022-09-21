package hr.inovatrend.carservicelora.manager.impl;

import hr.inovatrend.carservicelora.entity.User;
import hr.inovatrend.carservicelora.repository.UserRepository;
import hr.inovatrend.carservicelora.manager.UserManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserManagerImpl implements UserManager {
    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public List<User> getAll() {

        return userRepository.findAll();

    }

    @Override
    public User getUser(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
