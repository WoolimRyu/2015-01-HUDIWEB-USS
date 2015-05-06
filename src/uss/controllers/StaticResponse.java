package uss.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uss.dao.UserDao;

@Controller
public class StaticResponse {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "forward:/register.html";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestDispatcher rd = request.getRequestDispatcher("/login.html");
		rd.forward(request, response);
	}

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public String profile(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "forward:/profile.html";
	}
}
