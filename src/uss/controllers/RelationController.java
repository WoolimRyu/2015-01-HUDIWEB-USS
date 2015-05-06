package uss.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uss.model.User;
import uss.model.response.Response;
import uss.service.RelationService;

import com.google.gson.Gson;

@RestController
@RequestMapping(value = "/api/relation", produces = MediaType.APPLICATION_JSON_VALUE)
public class RelationController {

	private static final Logger logger = LoggerFactory.getLogger(RelationController.class);

	@Autowired
	private RelationService service;

	@Autowired
	private Gson gson;

	@RequestMapping(method = RequestMethod.POST)
	public Response add(HttpServletRequest request) throws Exception {
		Response response = service.addRelation((User) request.getSession().getAttribute("user"),
				ServletRequestUtils.getStringParameter(request, "addId"));
		logger.debug("id");
		return response;
	}

	@RequestMapping(value = "/getList", method = RequestMethod.POST)
	public Response getList(HttpServletRequest request) throws Exception {
		return service.getRelation((User) request.getSession().getAttribute("user"));
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public Response delete(HttpServletRequest request) throws Exception {
		Response response = service.deleteRelation((User) request.getSession().getAttribute("user"),
				ServletRequestUtils.getStringParameter(request, "deleteId"));
		return response;
	}

}
