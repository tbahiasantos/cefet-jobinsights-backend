package br.com.taugs.jobinsights.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GenerateTokenException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1527698377128899663L;
	private static final Logger LOGGER = Logger.getLogger(GenerateTokenException.class.getName());

	public GenerateTokenException() {
		LOGGER.log(Level.SEVERE, "Erro ao gerrar token jwt");
	}

}
