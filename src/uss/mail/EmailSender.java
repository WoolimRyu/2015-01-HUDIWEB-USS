package uss.mail;


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
	@Autowired
	private SimpleMailMessage mailMessage;
	
	public void sendEmail(Email email) throws MessagingException {
	
		MimeMessage message = mailSender.createMimeMessage();
		
		message.setFrom(new InternetAddress(mailMessage.getFrom()));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));
		message.setSubject(email.getSubject());
		message.setContent(email.getContent(), "text/html charset=utf-8");
		
		mailSender.send(message);

	}
}
