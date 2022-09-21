package hr.inovatrend.carservicelora.controller;

import hr.inovatrend.carservicelora.manager.UserManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
@SessionAttributes("user")
@RequiredArgsConstructor
public class IndexController {
    private final UserManager userManager;

    @GetMapping
    private String index(Model model) {
        model.addAttribute("users", userManager.getAll());
        return "index";
    }


}

