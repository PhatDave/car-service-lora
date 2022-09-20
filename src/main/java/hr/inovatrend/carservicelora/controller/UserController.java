package hr.inovatrend.carservicelora.controller;

import hr.inovatrend.carservicelora.entity.User;
import hr.inovatrend.carservicelora.service.CarService;
import hr.inovatrend.carservicelora.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final CarService carService;

    @GetMapping("/add")
    private String userAdd(Model model) {

        model.addAttribute("user", new User()); //dodaje novog usera u bazu
        return "user/add-user";
    }

    @PostMapping("/add")
    private String addUser(@ModelAttribute User user) { //pravi novog usera za dodavanje u bazu
        userService.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/{userID}")
    private String userInfo(Model model, @PathVariable Long userID) {


        User user = userService.getUser(userID);

        model.addAttribute("users", user);

        var cars = carService.getByUser(user);

        model.addAttribute("cars", cars);


        return "user/info-user";
    }

    @GetMapping("/all")
    private String userAll(Model model) {

        model.addAttribute("users", userService.getAll());
        return "user/all-users";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) { //dodaje nove podate u bazu za već postojanog usera
        User user = userService.getUser(id);

        model.addAttribute("user", user);
        return "/user/add-user";
    }


    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        User user = userService.getUser(id);
        userService.deleteById(user.getId());
        return "redirect:../../user/all";
    }

}