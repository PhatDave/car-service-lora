package hr.inovatrend.carservicelora.controller;

import hr.inovatrend.carservicelora.entity.Car;
import hr.inovatrend.carservicelora.entity.User;
import hr.inovatrend.carservicelora.entity.enums.CarManufacturer;
import hr.inovatrend.carservicelora.manager.CarManager;
import hr.inovatrend.carservicelora.manager.UserManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/car")
@SessionAttributes("car")
@RequiredArgsConstructor
public class CarController {

    private final CarManager carManager;
    private final UserManager userManager;

    @GetMapping("/add")
    private String carAdd(Model model) {

        var users = userManager.getAll();
        model.addAttribute("car", new Car()); //dodaje novi auto u bazu
        model.addAttribute("users", users);
        model.addAttribute("manufacturers", CarManufacturer.values());


        return "car/add-car";
    }

    @PostMapping("/add")
    private String addCar(@ModelAttribute Car car) { //pravi novi auto za dodavanje u bazu
        carManager.createCar(car);


        return "redirect:/";
    }

    @GetMapping("/{carID}")
    private String carInfo(Model model, @PathVariable Long carID) {

        model.addAttribute("cars", carManager.getCar(carID));
        return "user/info-user";
    }

    @GetMapping("/all")
    private String carAll(Model model) {

        model.addAttribute("cars", carManager.getAll());
        return "car/all-cars";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) { //dodaje nove podatke u bazu za već postojanog cara
        Optional<Car> car = carManager.getCar(id);


        if (car.isPresent()) {
            Car carObj = car.get();


            List<User> users = userManager.getAll();
            model.addAttribute("car", carObj);
            model.addAttribute("users", users);
            model.addAttribute("manufacturers", CarManufacturer.values());
            return "car/add-car";
        }


        return "/car/add-car";
    }


    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") long id) {


        Optional<Car> car = carManager.getCar(id);
        if (car.isPresent()) {
            Car carObj = car.get();
            carManager.deleteById(carObj.getId());
        }

        return "redirect:../../car/all";
    }


}
