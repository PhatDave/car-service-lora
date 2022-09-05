package hr.inovatrend.carservicelora.repository;

import hr.inovatrend.carservicelora.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
