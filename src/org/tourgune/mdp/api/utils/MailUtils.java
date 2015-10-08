package org.tourgune.mdp.api.utils;



import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailUtils{
	
	@Resource
	private JavaMailSender mailSender;
	private MimeMessage message;
	 
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
 
	public void sendMail(String cause, String msg) {		
		message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

			helper.setFrom(Constants.MAIL_FROM);
//	        helper.setTo(to);
			helper.setTo(InternetAddress.parse(Constants.MAIL_TO));
			helper.setSubject(Constants.MAIL_SUBJECT_PREFIX + cause);
	        helper.setText(msg);
	        
	        mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
