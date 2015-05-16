package uss.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uss.service.GroupService;

import com.google.gson.Gson;

@RestController
@RequestMapping(value = "/api/group", produces = MediaType.APPLICATION_JSON_VALUE)
public class GroupController {
	private static final Logger logger = LoggerFactory.getLogger(GroupController.class);

	@Autowired
	private GroupService service;

	@Autowired
	private Gson gson;

}
