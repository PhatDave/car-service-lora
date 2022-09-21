package hr.inovatrend.carservicelora.controller;

import hr.inovatrend.carservicelora.entity.Car;
import hr.inovatrend.carservicelora.entity.Service;
import hr.inovatrend.carservicelora.entity.User;
import hr.inovatrend.carservicelora.entity.enums.CarManufacturer;
import hr.inovatrend.carservicelora.manager.CarManager;
import hr.inovatrend.carservicelora.manager.ServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/service")
@SessionAttributes("service")
@RequiredArgsConstructor
public class ServiceController {

    private final CarManager carManager;
    private final ServiceManager serviceManager;

    @GetMapping("/add")
    private String serviceAdd(Model model) {

        var cars = carManager.getAll();

        model.addAttribute("service", new Service());
        model.addAttribute("cars", cars);


        return "service/add-service";
    }

    @PostMapping("/add")
    private String addService(@ModelAttribute Service service) {
        serviceManager.createService(service);

        return "redirect:/";
    }


}
