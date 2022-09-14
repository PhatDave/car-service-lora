package hr.inovatrend.carservicelora.repository;

import hr.inovatrend.carservicelora.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    void deleteById(Long id);
    User findUserById(Long id);
}