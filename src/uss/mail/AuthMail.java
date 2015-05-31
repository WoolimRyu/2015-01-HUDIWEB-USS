package uss.mail;

import java.util.Random;

import uss.model.User;

public class AuthMail extends Email{

	private static final String HEAD = "About Me 이메일 인증 메일입니다.";
	public static final String CONTENT = "<!DOCTYPE html><html><head lang=\"en\"><meta charset=\"UTF-8\">" + "<title>mail from begin.at</title>"
			+ "</head><body><h3>사람들을 연결해주는 명함 플랫폼. <a href=\"http://begin.at\">About Me</a>에 가입하신것을 환영합니다.</h3>"
			+ "<h1><a href=\"http://begin.at/api/auth/email/{{email}}/{{authcode}}\" target=\"_blank\">메일 인증받기</a></h1>"
			+ "<h3><a href=\"http://begin.at/api/auth/removeMember/{{email}}/{{authcode}}\" target=\"_blank\">제가 가입하지 않았어요. 메일 도용입니다.(회원삭제)</a></h3>"
			+ "</body></html>";
	
	public AuthMail(User user) {
		AuthCodeGenerator generator = new AuthCodeGenerator(new Random());
		String authcode = generator.make(user.getStringId().length());
		this.to = user.getEmail();
		this.subject = HEAD;
		this.content = CONTENT.replaceAll("\\{\\{authcode\\}\\}", authcode).replaceAll("\\{\\{email\\}\\}", to);
	}
}
