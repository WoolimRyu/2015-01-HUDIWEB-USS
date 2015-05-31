package uss.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private TaskExecutor taskExecutor;
	
	public void sendEmail(Email email) throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setTo(email.getTo());
		message.setSubject(email.getSubject());
		message.setText(email.getContent(), "utf-8", "html");
		
		taskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				mailSender.send(message);
			}
		});
		
	}
}
