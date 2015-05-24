package uss.service.mail;

public class PasswordMail extends Email {

	public static final String BODY = "<!DOCTYPE html>" + "<html>" + "<head lang='en'>" + "   <meta charset='UTF-8'>"
			+ "   <title>mail from begin.at</title></head>" + "<body><h3><a href='http://begin.at'>Begin@</a> 패스워드를 변경합니다.</h3>" +

			"<form method='post' action='http://begin.at/api/auth/password'> 변경할 패스워드" + "    <input name='password' type='password'>"
			+ "    <input type='hidden' value='{{email}}' name='user'>" + "    <input type='hidden' value='{{authcode}}' name='code'>"
			+ "    <input type='submit' value='변경하기'/>" + "</form>" + "</body>" + "</html>";

	private static final String head = "Begin@ 패스워드 변경 메일입니다.";

	public PasswordMail(String to, String authcode) {
		this.to = to;
		this.subject = head;
		this.body = BODY.replaceAll("\\{\\{authcode\\}\\}", authcode).replaceAll("\\{\\{email\\}\\}", to);
	}

}
