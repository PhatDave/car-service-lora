package hr.inovatrend.carservicelora.service;

import hr.inovatrend.carservicelora.entity.Car;
import hr.inovatrend.carservicelora.entity.User;

import java.util.List;
import java.util.Optional;

public interface CarService {

    Car createCar(Car car);
    List<Car> getAll();

    Optional<Car> getCar(Long id);

    List<Car> getByUser(User user);

    List<Car> getByUserId(Long id);

    void deleteById(Long id);

}