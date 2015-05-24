package uss.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
	private Properties props;
	
	public void sendEmail(String from, String to, String subject, String content) {
		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setContent(content, "text/html charset=utf-8");
			
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
