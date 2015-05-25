package uss.mail;


import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
	
	@Autowired
	private JavaMailSender mailSender;
	
	private static final String authhead = "이메일 인증 메일입니다.";
	
	public static final String BODY = "<!DOCTYPE html><html><head lang=\"en\"><meta charset=\"UTF-8\">" + "<title>mail from begin.at</title>"
			+ "</head><body><h3>새로운 사랑이 시작되는 곳 <a href=\"http://begin.at\">Begin@</a>에 가입하신것을 환영합니다.</h3>"
			+ "<h1><a href=\"http://begin.at/api/auth/email/{{email}}/{{authcode}}\" target=\"_blank\">메일 인증받기</a></h1>"
			+ "<h3><a href=\"http://begin.at/api/auth/removeMember/{{email}}/{{authcode}}\" target=\"_blank\">제가 가입하지 않았어요. 메일 도용입니다.(회원삭제)</a></h3>"
			+ "</body></html>";
	
	public void sendEmail(Email email) throws MessagingException {
	
//		MimeMessage message = mailSender.createMimeMessage();
//		
//		message.setFrom(new InternetAddress(mailMessage.getFrom()));
//		message.setRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));
//		message.setSubject(email.getSubject());
//		message.setContent(email.getContent(), "text/html charset=utf-8");
//		
//		mailSender.send(message);
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setTo(email.getTo());
		message.setSubject(email.getSubject());
		message.setText(email.getContent());
		
		mailSender.send(message);
	}

	public void sendAuthEmail(String to) throws MessagingException {
		String authcode = createAuth();
		sendEmail(new Email(to, authhead, BODY.replaceAll("\\{\\{authcode\\}\\}", authcode).replaceAll("\\{\\{email\\}\\}", to)));
	}

	private String createAuth() {
		UUID uuid = UUID.randomUUID();
		String authcode = uuid.toString();
		
		return authcode;
	}
}
