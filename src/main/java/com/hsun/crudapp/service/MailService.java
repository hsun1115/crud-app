package com.hsun.crudapp.service;

public interface MailService {
	public void sendSimpleMail(String to, String subject, String content);

	public void sendHtmlMail(String to, String subject, String content);

	public void sendAttachmentsMail(String to, String subject, String content, String filepath);

	public void sendInlineResourceMail(String to, String subject, String content, String rcsPath, String rscId);
}