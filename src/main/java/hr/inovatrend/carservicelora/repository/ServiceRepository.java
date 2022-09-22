package hr.inovatrend.carservicelora.repository;

import hr.inovatrend.carservicelora.entity.Car;
import hr.inovatrend.carservicelora.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    List<Service> findByAuto_Id(Long id);

    List<Service> findAllByOrderByDatetimeDesc();

}
