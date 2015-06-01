package uss.launcher;

import uss.model.User;
import uss.model.cards.AddedCards;
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
		dao.insert(new User("test1", "password1", "pass1@tea.com", "박재성", 1));
		dao.insert(new User("test2", "password1", "pass1@tea.com", "윤지수", 2));
		dao.insert(new User("test3", "password1", "pass1@tea.com", "김태곤", 3));
		dao.insert(new User("test4", "password1", "pass1@tea.com", "박근혜", 4));
		dao.insert(new User("test5", "password1", "pass1@tea.com", "문재인", 5));
		dao.insert(new User("test6", "password1", "pass1@tea.com", "김무성", 6));
		dao.insert(new User("test7", "password1", "pass1@tea.com", "백종원", 7));
		
		dao.insert(new AddedCards(1, 1, null));
		dao.insert(new AddedCards(1, 2, null));
		dao.insert(new AddedCards(1, 3, null));
		dao.insert(new AddedCards(1, 4, null));
		dao.insert(new AddedCards(1, 5, null));
		dao.insert(new AddedCards(2, 1, null));
		dao.insert(new AddedCards(2, 2, null));
		dao.insert(new AddedCards(2, 3, null));
		dao.insert(new AddedCards(2, 4, null));
		dao.insert(new AddedCards(3, 1, null));
		dao.insert(new AddedCards(3, 2, null));
		dao.insert(new AddedCards(3, 3, null));
		dao.insert(new AddedCards(4, 1, null));
		dao.insert(new AddedCards(4, 2, null));
		dao.insert(new AddedCards(4, 3, null));
		
		dao.insert(new Card(1, "사람", "010-666-6568", "email@email.com", "NHNNEXT", "분당", null, "교수", 1));
		dao.insert(new Card(1, "박재성", "010-666-6568", "email@email.com", "NHNNEXT", "분당", null, "대통령", 1));
		dao.insert(new Card(1, "문근혜", "010-666-6568", "email@email.com", "NHNNEXT", "분당", null, "교수", 1));
		dao.insert(new Card(1, "우리미", "010-666-6568", "email@email.com", "NHNNEXT", "분당", null, "교수", 1));
		dao.insert(new Card(1, "도호", "010-666-6568", "email@email.com", "NHNNEXT", "분당", null, "교수", 1));
		dao.insert(new Card(1, "반고흐", "010-666-6568", "email@email.com", "NHNNEXT", "분당", null, "교수", 1));
		dao.insert(new Card(1, "피카소", "010-666-6568", "email@email.com", "NHNNEXT", "분당", null, "교수", 1));
		dao.insert(new Card(1, "앤디워홀", "010-666-6568", "email@email.com", "NHNNEXT", "분당", null, "교수", 1));
		dao.insert(new Card(1, "그림", "010-666-6568", "email@email.com", "NHNNEXT", "분당", null, "교수", 1));
		
	}

}
