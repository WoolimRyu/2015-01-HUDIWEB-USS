package uss.controller;

import next.jdbc.mysql.exception.RegexNotMatchedException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import uss.response.Response;
import uss.response.Result;

@RestController
public class ExceptionHandlerController {

	@ExceptionHandler(RegexNotMatchedException.class)
	public Response handle(RegexNotMatchedException e) {
		return Result.getErrorRegexNotMatched(e.getMessage());
	}

}
