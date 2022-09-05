package hr.inovatrend.carservicelora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lora")
public class IndexController {
	@GetMapping("/123")
	private String index() {
		return "index";
	}
}
