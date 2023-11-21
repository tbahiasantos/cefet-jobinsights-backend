package br.com.taugs.jobinsights.api.vagaaluno.model.pk;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VagaAlunoPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2016299077177252844L;

	private Long idAluno;

	private Long idVaga;

}
