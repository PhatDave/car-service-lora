package hr.inovatrend.carservicelora.controller;

import hr.inovatrend.carservicelora.entity.User;
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

    @GetMapping("/add")
    private String userAdd(Model model) {

        model.addAttribute("user", new User());
        return "user/add-user";
    }

    @PostMapping("/add")
    private String addUser(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/info/{userID}")
    private String userInfo(Model model, @PathVariable Long userID){

        model.addAttribute("users", userService.getUser(userID));
        return "user/info-user";
    }

    @GetMapping("/all")
    private String userAll(Model model){

        model.addAttribute("users", userService.getAll());
        return "user/all-users";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        User user = userRepository.findUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "edit-user";
    }

}
