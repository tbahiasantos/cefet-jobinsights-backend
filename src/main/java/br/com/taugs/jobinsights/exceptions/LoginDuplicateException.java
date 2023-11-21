package br.com.taugs.jobinsights.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDuplicateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3031896068621299102L;

	private static final Logger LOGGER = Logger.getLogger(LoginDuplicateException.class.getName());

	public LoginDuplicateException(String login) {
		LOGGER.log(Level.SEVERE, "O login {0} já esta sendo utilizado por outro usuário", login);
	}

}
