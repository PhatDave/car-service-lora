package hr.inovatrend.carservicelora.manager;

import hr.inovatrend.carservicelora.entity.Car;
import hr.inovatrend.carservicelora.entity.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceManager {

    Service createService(Service service);

    List<Service> getCarServicesByCar(Car car);

    List<Service> getCarServicesByCarId(Long id);

    List<Service> getRecentServices(int limit);

    List<Service> getAll();

    Optional<Service> getService(Long id);

    void deleteById(Long id);

}
