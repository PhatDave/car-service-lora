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


    @GetMapping("/{serviceID}")
    private String serviceInfo(Model model, @PathVariable Long serviceID) {

        model.addAttribute("service", serviceManager.getService(serviceID));
        return "user/info-user";
    }


    @GetMapping("/all")
    private String serviceAll(Model model) {

        model.addAttribute("services", serviceManager.getAll());
        return "user/info-user";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) { //dodaje nove podatke u bazu za već postojanog cara
        Optional<Service> service = serviceManager.getService(id);


        if (service.isPresent()) {
            Service serviceObj = service.get();

            List<Car> cars = carManager.getAll();

            model.addAttribute("service", serviceObj);
            model.addAttribute("cars", cars);

            return "car/add-service";
        }


        return "/car/add-service";
    }


    @GetMapping("/delete/{id}")
    public String deleteService(@PathVariable("id") long id) {


        Optional<Service> service = serviceManager.getService(id);
        if (service.isPresent()) {
            Service serviceObj = service.get();
            serviceManager.deleteById(serviceObj.getId());
        }

        return "redirect:../../service/all";
    }

}
