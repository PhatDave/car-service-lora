package hr.inovatrend.carservicelora.controller;

import hr.inovatrend.carservicelora.entity.User;
import hr.inovatrend.carservicelora.service.UserService;
import hr.inovatrend.carservicelora.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
@SessionAttributes("user")
@RequiredArgsConstructor
public class IndexController {
    private final UserService userService;

    @GetMapping
    private String index(Model model) {
        model.addAttribute("users", userService.getAll());
        return "index";
    }


}

