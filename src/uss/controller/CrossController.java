package uss.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uss.util.HttpReq;

@RestController
@RequestMapping(value = "/api/cross", produces =  "application/text; charset=utf-8")
public class CrossController {

	private static final String map = "http://openapi.map.naver.com/api/geocode?key=8c0647eaaa13e3692462b2a8c7d2b1bc&encoding=utf-8&coord=latlng&output=json&query=";

	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public String map(String query) {
		return HttpReq.excute("GET", map + query, "");
	}

	private static final String search = "http://openapi.naver.com/search?key=9e11e6f6897b9309c6125fb96534f298&target=local&start=1&display=10&query=";

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(String query) {
		String result = HttpReq.excute("GET", search + query, "");
		
		return result;
	}

}
