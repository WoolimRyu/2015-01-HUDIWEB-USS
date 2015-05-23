package uss.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uss.model.User;
import uss.response.Response;
import uss.service.UserService;

@Controller
public class UserController {
	
	private static final String USER = "user";
	UserService service;

	@RequestMapping(value="/user", method=RequestMethod.GET)
	public User getUser(User user) {
		return user;
	}
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public Response register(User user) {
		return service.register(user);
	}
	
	@RequestMapping(value="/user", method=RequestMethod.PUT)
	public Response update(User user, HttpSession session) {
		User loginUser = (User) session.getAttribute(USER);
		return service.update(user, loginUser);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public Response login(User user) {
		return service.login(user);
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public Response search(User user) {
		return service.search(user);
	}
	
//	@RequestMapping(value="/{userId}", method=RequestMethod.GET)
//	public Response search(@PathVariable String userId) {
//		
//		return service.search(User);
//	}


	
}
