package hr.inovatrend.carservicelora.repository;

import hr.inovatrend.carservicelora.entity.Car;
import hr.inovatrend.carservicelora.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByKlijent(User user);

    List<Car> findByKlijent_Id(Long id);
}
