package hr.inovatrend.carservicelora.service.impl;

import hr.inovatrend.carservicelora.entity.User;
import hr.inovatrend.carservicelora.repository.UserRepository;
import hr.inovatrend.carservicelora.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}
}
