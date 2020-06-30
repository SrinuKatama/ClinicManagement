package com.example.demo.Utility;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import com.example.demo.responses.MailDto;

public class MailUtility implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	JavaMailSender mailsender;

	public void sendMail(MailDto maildto) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(maildto.getEmail());
		message.setSubject(maildto.getSubject());
		message.setText(maildto.getResponse());
		mailsender.send(message);
	}

}
