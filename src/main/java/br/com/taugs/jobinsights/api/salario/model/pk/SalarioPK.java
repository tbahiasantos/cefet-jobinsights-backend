package br.com.taugs.jobinsights.api.salario.model.pk;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalarioPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2638488347494569223L;

	private Long idAluno;

	private Long idEmpresa;

}
