package uss.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uss.model.User;
import uss.model.result.Result;
import uss.model.result.ResultWithObject;
import uss.service.UserService;

import com.google.gson.Gson;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService service;

	@Autowired
	private Gson gson;

	@RequestMapping(method = RequestMethod.POST)
	public Result register(HttpServletRequest request) throws Exception {
		User user = gson.fromJson(ServletRequestUtils.getStringParameter(request, "user"), User.class);
		Result result = service.register(user);
		return result;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResultWithObject login(HttpServletRequest request) throws Exception {
		User user = gson.fromJson(ServletRequestUtils.getStringParameter(request, "user"), User.class);
		ResultWithObject response = service.login(user);
		if (!response.getResult().isError())
			request.getSession().setAttribute("user", response.getResult());
		return response;
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().removeAttribute("user");
		return "redirect:/";
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Result update(HttpServletRequest request) throws Exception {
		User user = gson.fromJson(ServletRequestUtils.getStringParameter(request, "user"), User.class);
		Result response = service.update(user, (User) request.getSession().getAttribute("user"));
		logger.debug("update test result userId : {}", user.getId());
		return response;
	}

}
