package uss.mail;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uss.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/applicationContext.xml", "file:webapp/WEB-INF/uss-servlet.xml"})
public class EmailSenderTest {
	private static final Logger logger = LoggerFactory.getLogger(EmailSenderTest.class);
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private EmailSender emailSender;
	
	@Test
	public void testSendEmail() throws MessagingException {
		emailSender.sendEmail(new Email("buyongjo@gmail.com", "subject", "content"));
	}
	
	@Test
	public void testSendAuthEmail() throws MessagingException {
		User user = new User();
		user.setStringId("test");
		user.setEmail("buyongjo@gmail.com");
		emailSender.sendEmail(new AuthMail(user));
	}
	
	
	@Test
	public void testSendMail() throws MessagingException {
		MockMailSender mockMailSender = new MockMailSender();
		EmailSender emailSender = new EmailSender();
		
		User user = new User();
		user.setEmail("dd@dd.net");
		emailSender.sendEmail(new Email());
		
		List<Email> request = mockMailSender.getRequests();
		assertEquals(request.get(0).getTo(), user.getEmail());
		logger.debug("authMail subject : {}", request.get(0).getSubject());
		logger.debug("authMail content : {}", request.get(0).getContent());
	}
	
	static class MockMailSender implements MailSender {
		private List<Email> requests = new ArrayList<Email>();	
		
		public List<Email> getRequests() {
			return requests;
		}

		public void send(SimpleMailMessage mailMessage) throws MailException {
			requests.add(new Email(mailMessage.getTo()[0], mailMessage.getSubject(), mailMessage.getText()));  
		}

		public void send(SimpleMailMessage[] mailMessage) throws MailException {
		}
	}

}
