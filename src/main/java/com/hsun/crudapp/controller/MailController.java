//package com.hsun.crudapp.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.hsun.crudapp.model.User;
//import com.hsun.crudapp.repository.UserRepository;
//import com.hsun.crudapp.service.MailService;
//
//@RestController
//public class MailController {
//
//	@Autowired
//	private MailService mailService;
//	private UserRepository userRepository;
//
//	@RequestMapping(value = "/sendSimpleMail/{id}")
//	public String sendSimpleMail(@PathVariable("id") Long id) {
//		User user2 = userRepository.findById(id)
//				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//		String email = user2.getEmail();
//		System.out.println(email);
//		mailService.sendSimpleMail(email, "Simple Mail Test",
//				"Hello, this is a simple mail send by Spring boot project.");
//		return "send-simple-mail";
//	}
//}
