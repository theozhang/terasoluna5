package com.dhc.uim.app.user;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dhc.uim.domain.model.User;
import com.dhc.uim.domain.service.user.UserService;

@Controller
@RequestMapping
public class UserController {
	@Inject // (1)
	UserService userService;

	@ModelAttribute // (2)
	public UserForm setUpForm() {
		UserForm form = new UserForm();
		return form;
	}

	@GetMapping("list") // (3)
	public String list(Model model) {
		Collection<User> users = userService.findAll();
		model.addAttribute("users", users); // (4)
		return "user/list"; // (5)
	}
}
