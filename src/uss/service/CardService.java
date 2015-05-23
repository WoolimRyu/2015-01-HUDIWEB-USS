package uss.service;

import java.util.List;

import org.springframework.stereotype.Service;

import uss.dao.CardDao;
import uss.model.Card;

@Service
public class CardService {

	CardDao dao;
	
	public List<Card> find(String key){
	
		return dao.findList(key);
	};
}
