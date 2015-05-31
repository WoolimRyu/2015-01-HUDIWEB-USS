package uss.launcher;

import uss.model.User;
import uss.model.cards.Card;
import next.jdbc.mysql.DAO;
import next.jdbc.mysql.maker.PackageCreator;

public class DBLauncher {

	public static void main(String[] args) {
		PackageCreator.reset();
		insertTestData();
	}

	public static void insertTestData() {
		DAO dao = new DAO();
		dao.insert(new User("test1", "password1", "pass1@tea.com", "name"));
		dao.insert(new User("test2", "password1", "pass1@tea.com", "name"));
		dao.insert(new User("test3", "password1", "pass1@tea.com", "name"));
		dao.insert(new User("test4", "password1", "pass1@tea.com", "name"));
		dao.insert(new User("test5", "password1", "pass1@tea.com", "name"));
		Card card = new Card();
		card.setUserId(1);
		dao.insert(card);
	}

}
