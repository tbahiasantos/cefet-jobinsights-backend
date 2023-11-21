package br.com.taugs.jobinsights.api.avaliacao.model.pk;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AvaliacaoPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2381805970220543238L;

	private Long idAluno;

	private Long idEmpresa;

}
