package uss.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import next.jdbc.mysql.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uss.model.zoin.UserCard;
import uss.response.Response;
import uss.response.Result;

@RestController
@RequestMapping("/api/search")
public class SearchController {
	
	@Autowired
	DAO dao;
	
	@RequestMapping(method = RequestMethod.GET)
	public Response search(String query, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String sql = "SELECT * FROM User JOIN Card "
				+ "ON User.userId = Card.userId "
				+ "WHERE User.name LIKE '%query%' OR User.email LIKE '%query%' "
				+ "OR Card.phoneNumber LIKE '%query%' OR Card.company LIKE '%query%'";
		
		sql = sql.replaceAll("query", query);
		List<UserCard> userCard = dao.getList(UserCard.class, sql);
		if (userCard == null)
			return Result.getErrorSearchNotFound();
		return Result.getSuccess(userCard);
	}
}
