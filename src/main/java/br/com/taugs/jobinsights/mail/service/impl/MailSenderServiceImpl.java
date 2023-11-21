package br.com.taugs.jobinsights.mail.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.com.taugs.jobinsights.mail.model.EmailRequestDTO;
import br.com.taugs.jobinsights.mail.service.MailSenderService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailSenderServiceImpl implements MailSenderService {

	private final JavaMailSender mailSender;

	@Autowired
	public MailSenderServiceImpl( //
	        JavaMailSender mailSender //
	) {
		this.mailSender = mailSender;
	}

	@Override
	public void sendMail(EmailRequestDTO emailRequestDTO) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");

		try {
			helper.setTo(emailRequestDTO.getPara());
			helper.setSubject(emailRequestDTO.getAssunto());
			helper.setText(emailRequestDTO.getTexto(), true);
			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			throw e;
		}
	}

}
