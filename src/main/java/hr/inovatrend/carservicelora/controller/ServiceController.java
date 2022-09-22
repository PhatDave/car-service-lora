package hr.inovatrend.carservicelora.controller;

import hr.inovatrend.carservicelora.entity.Car;
import hr.inovatrend.carservicelora.entity.Service;
import hr.inovatrend.carservicelora.entity.User;
import hr.inovatrend.carservicelora.entity.enums.CarManufacturer;
import hr.inovatrend.carservicelora.manager.CarManager;
import hr.inovatrend.carservicelora.manager.ServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        Optional<Service> service = serviceManager.getService(id);


        if (service.isPresent()) {
            Service serviceObj = service.get();

            List<Car> cars = carManager.getAll();

            model.addAttribute("service", serviceObj);
            model.addAttribute("cars", cars);

            return "service/add-service";
        }


        return "service/add-service";
    }


    @GetMapping("/delete/{id}")
    public String deleteService(@PathVariable("id") long id) {


        Optional<Service> service = serviceManager.getService(id);
        if (service.isPresent()) {

            Service serviceObj = service.get();
            var clientID = serviceObj.getAuto().getKlijent().getId();
            serviceManager.deleteById(serviceObj.getId());

            return "redirect:../../user/" + clientID;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found.");

    }

}
