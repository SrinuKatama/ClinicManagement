package com.bridgelabs.Utility;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.bridgelabs.responses.Mailobject;

@Component
public class MailUtility implements Serializable 
{
	private static final long serialVersionUID = 1L;
	@Autowired
	JavaMailSender mailsender;

	public void sendMail(Mailobject mailobject) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(mailobject.getEmail());
		message.setSubject(mailobject.getSubject());
		message.setText(mailobject.getResponse());
		mailsender.send(message);
	}

}
