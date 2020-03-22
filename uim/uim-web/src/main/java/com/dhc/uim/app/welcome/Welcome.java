package com.dhc.uim.app.welcome;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class Welcome {
	@GetMapping("/") // (3)
	public String welcome(Model model) {
		return "welcome/home"; // (5)
	}
}
