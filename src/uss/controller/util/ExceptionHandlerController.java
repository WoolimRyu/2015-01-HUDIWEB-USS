package uss.controller.util;

import next.jdbc.mysql.exception.RegexNotMatchedException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import uss.response.Response;
import uss.response.Result;
import uss.util.exception.SessionNullException;

@Controller
public class ExceptionHandlerController {

	@ExceptionHandler(RegexNotMatchedException.class)
	public Response handle(RegexNotMatchedException e) {
		return Result.getErrorRegexNotMatched(e.getMessage());
	}
	
	@ExceptionHandler(SessionNullException.class)
	public String handle1(SessionNullException e) {
		return "redirect:/home/login.html";
	}

}
