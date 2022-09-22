package hr.inovatrend.carservicelora.manager.impl;

import hr.inovatrend.carservicelora.entity.Car;
import hr.inovatrend.carservicelora.entity.Service;
import hr.inovatrend.carservicelora.manager.ServiceManager;
import hr.inovatrend.carservicelora.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceManagerImpl implements ServiceManager {

    private final ServiceRepository serviceRepository;

    @Override
    public Service createService(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public List<Service> getCarServicesByCar(Car car) {

        return null;
    }

    @Override
    public List<Service> getCarServicesByCarId(Long id) {
        return serviceRepository.findByAuto_Id(id);
    }

    @Override
    public List<Service> getRecentServices(int limit) {

        List<Service> services = serviceRepository.findAllByOrderByDatetimeDesc();
        if (services.size() < limit) {
            limit = services.size();
        }
        List<Service> limitedServices = services.subList(0, limit);
        return limitedServices;

    }

    @Override
    public List<Service> getAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Optional<Service> getService(Long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {

        serviceRepository.deleteById(id);

    }


}
