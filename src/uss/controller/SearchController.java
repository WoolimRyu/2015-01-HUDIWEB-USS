package uss.controller;

import next.jdbc.mysql.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uss.response.Response;

@RestController
@RequestMapping("/api")
public class SearchController {
	
	@Autowired
	DAO dao;
	
	@RequestMapping(method = RequestMethod.GET)
	public Response search(Object object) {
		
		
		return null;
	}
}
