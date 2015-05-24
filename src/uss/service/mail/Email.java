package uss.service.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

	private static final String SERVICE_MAIL = "love@begin.at";
	private static final Properties mailServerProperties = new Properties();
	static {
		mailServerProperties.put("mail.smtp.host", "localhost");
		mailServerProperties.put("mail.smtp.port", "25");
	}
	
	protected String to;
	protected String subject;
	protected String body;

	public void send() {
		Session session = Session.getDefaultInstance(mailServerProperties);
		MimeMessage messageToSend = new MimeMessage(session);
		try {
			messageToSend.setFrom(new InternetAddress(SERVICE_MAIL));
			messageToSend.addRecipient(Message.RecipientType.TO, new InternetAddress(this.to));
			messageToSend.setSubject(this.subject);
			messageToSend.setContent(this.body, "text/html; charset=utf-8");
			Transport.send(messageToSend);
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
	}
}
