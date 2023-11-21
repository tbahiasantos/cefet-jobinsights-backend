package br.com.taugs.jobinsights.mail.service;

import br.com.taugs.jobinsights.mail.model.EmailRequestDTO;
import jakarta.mail.MessagingException;

public interface MailSenderService {

	public void sendMail(EmailRequestDTO emailRequestDTO) throws MessagingException;

}
