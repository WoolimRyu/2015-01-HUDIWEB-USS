package uss.service.mail;

public class EmailAuth extends Email {

	public static final String BODY = "<!DOCTYPE html><html><head lang=\"en\"><meta charset=\"UTF-8\">" + "<title>mail from begin.at</title>"
			+ "</head><body><h3>새로운 사랑이 시작되는 곳 <a href=\"http://begin.at\">Begin@</a>에 가입하신것을 환영합니다.</h3>"
			+ "<h1><a href=\"http://begin.at/api/auth/email/{{email}}/{{authcode}}\" target=\"_blank\">메일 인증받기</a></h1>"
			+ "<h3><a href=\"http://begin.at/api/auth/removeMember/{{email}}/{{authcode}}\" target=\"_blank\">제가 가입하지 않았어요. 메일 도용입니다.(회원삭제)</a></h3>"
			+ "</body></html>";

	private static final String head = "Begin@ 이메일 인증 메일입니다.";

	public EmailAuth(String to, String authcode) {
		this.to = to;
		this.subject = head;
		this.body = BODY.replaceAll("\\{\\{authcode\\}\\}", authcode).replaceAll("\\{\\{email\\}\\}", to);
	}

}
