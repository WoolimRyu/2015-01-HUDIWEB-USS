package uss.mail;

public class Email {
	protected String to;
	protected String subject;
	protected String content;
	
	public Email() {
		
	}
	
	public Email(String to, String subject, String content) {
		this.to = to;
		this.subject = subject;
		this.content = content;
	}

	public String getTo() {
		return to;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public String getContent() {
		return content;
	}
}
