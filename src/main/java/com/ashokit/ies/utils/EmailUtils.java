package com.ashokit.ies.utils;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;

@Repository
public class EmailUtils {
	@Autowired
	private JavaMailSender javaMailSender;

	public boolean sendEmail(String to, String subject, String body) {

		boolean isSent = false;

		try {

			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);

			messageHelper.addTo(to);
			messageHelper.setSubject(subject);
			messageHelper.setText(body, true);

			javaMailSender.send(mimeMessage);
			isSent = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSent;

	}

}
