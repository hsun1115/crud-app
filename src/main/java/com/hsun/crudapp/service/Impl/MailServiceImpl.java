package com.hsun.crudapp.service.Impl;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.hsun.crudapp.service.MailService;


@Component
public class MailServiceImpl implements MailService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JavaMailSender mailSender;

	@Value("${mail.fromMail.addr}")
	private String from;

	@Override
	public void sendSimpleMail(String to, String subject, String content) {
		// TODO Auto-generated method stub
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);

		try {
			mailSender.send(message);
			logger.info("Mail sent success!");
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception during simple mail sending!", e);
		}

	}

	@Override
	public void sendHtmlMail(String to, String subject, String content) {
		// TODO Auto-generated method stub
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content, true);

			mailSender.send(message);
			logger.info("html mail sent success!");
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception during html mail sending!", e);
		}
	}

	@Override
	public void sendAttachmentsMail(String to, String subject, String content, String filepath) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendInlineResourceMail(String to, String subject, String content, String rcsPath, String rscId) {
		// TODO Auto-generated method stub

	}

}
