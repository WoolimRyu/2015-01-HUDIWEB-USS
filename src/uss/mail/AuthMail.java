package uss.mail;

import java.util.Random;

import uss.model.User;

public class AuthMail extends Email{

	private static final String HEAD = "About Me 이메일 인증 메일입니다.";
	public static final String CONTENT = "<!DOCTYPE html><html><head lang=\"en\"><meta charset=\"UTF-8\">" + "<title>mail from begin.at</title>"
			+ "</head><body><h3>사람들을 연결해주는 명함 플랫폼. <a href=\"http://begin.at\">About Me</a>에 가입하신것을 환영합니다.</h3>"
			+ "<h1><a href=\"localhost:8080/api/auth?stringId={{id}}&authcode={{authcode}}\" target=\"_blank\">메일 인증받기</a></h1>"
			+ "</body></html>";
	
	public AuthMail(User user) {
		AuthCodeGenerator generator = new AuthCodeGenerator(new Random());
		String authcode = generator.make(user.getStringId().length());
		String id = user.getStringId();
		
		user.setAuthcode(authcode);
		
		this.to = user.getEmail();
		this.subject = HEAD;
		this.content = CONTENT.replaceAll("\\{\\{authcode\\}\\}", authcode).replaceAll("\\{\\{id\\}\\}", id);
		System.out.println(content);
	}
}
