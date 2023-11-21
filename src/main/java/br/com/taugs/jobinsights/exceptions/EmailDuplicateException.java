package br.com.taugs.jobinsights.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EmailDuplicateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4503621281651528742L;
	private static final Logger LOGGER = Logger.getLogger(EmailDuplicateException.class.getName());

	public EmailDuplicateException(String email) {
		LOGGER.log(Level.SEVERE, "O email {0} já esta sendo utilizado por outro usuário", email);
	}

}
