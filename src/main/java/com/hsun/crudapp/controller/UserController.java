package com.hsun.crudapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hsun.crudapp.model.User;
import com.hsun.crudapp.repository.UserRepository;
import com.hsun.crudapp.service.MailService;

@Controller
public class UserController {
	private final UserRepository userRepository;
	@Autowired
	private MailService mailService;

	@Autowired
	public UserController(UserRepository userRepository) {
		// TODO Auto-generated constructor stub
		this.userRepository = userRepository;
	}

	@RequestMapping(value = "/sendSimpleMail/{id}", method=RequestMethod.GET)
	public String sendSimpleMail(@PathVariable("id") Long id, Model model) throws Exception {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		String email = user.getEmail();
		System.out.println(email);
		mailService.sendSimpleMail(email, "Simple Mail Test",
				"Hello, this is a simple mail send by Spring boot project.");
		userRepository.save(user);
		model.addAttribute("users", userRepository.findAll());
		return "index";
	}
//	@GetMapping("/home")
//	public String backHome(@Valid User user,  Model model) {
//		userRepository.save(user);
//		model.addAttribute("users", userRepository.findAll());
//		return "index";
//	}

	@GetMapping("/signup")
	public String showSignUpForm(User user) {
		return "add-user";
	}

	@PostMapping("/adduser")
	public String addUser(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-user";
		}

		userRepository.save(user);
		model.addAttribute("users", userRepository.findAll());
		return "index";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		model.addAttribute("user", user);
		return "update-user";
	}

	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") Long id, @Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			user.setId(id);
			return "update-user";
		}

		userRepository.save(user);
		model.addAttribute("users", userRepository.findAll());
		return "index";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") Long id, Model model) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		userRepository.delete(user);
		model.addAttribute("users", userRepository.findAll());
		return "index";
	}

}
