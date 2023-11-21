package br.com.taugs.jobinsights.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InvalidEmailException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1185307255200073210L;
	private static final Logger LOGGER = Logger.getLogger(InvalidEmailException.class.getName());

	public InvalidEmailException() {
		LOGGER.log(Level.SEVERE, "Epenas emails com o domínio @aluno.cefetmg.br podem ser cadastrados");
	}

}
