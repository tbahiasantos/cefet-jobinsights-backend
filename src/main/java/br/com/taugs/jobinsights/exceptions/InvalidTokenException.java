package br.com.taugs.jobinsights.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InvalidTokenException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6400252137207668590L;

	private static final Logger LOGGER = Logger.getLogger(InvalidTokenException.class.getName());

	public InvalidTokenException() {
		LOGGER.log(Level.SEVERE, "Token JWT inválido ou expirado!");
	}

}
