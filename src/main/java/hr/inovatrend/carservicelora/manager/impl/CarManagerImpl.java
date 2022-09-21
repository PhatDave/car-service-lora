package hr.inovatrend.carservicelora.manager.impl;


import hr.inovatrend.carservicelora.entity.Car;
import hr.inovatrend.carservicelora.entity.User;
import hr.inovatrend.carservicelora.repository.CarRepository;
import hr.inovatrend.carservicelora.manager.CarManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarManagerImpl implements CarManager {

    private final CarRepository carRepository;

    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> getCar(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public List<Car> getByUser(User user) {
        return carRepository.findByKlijent(user);
    }

    @Override
    public List<Car> getByUserId(Long id) {
        return carRepository.findByKlijent_Id(id);
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }
}
