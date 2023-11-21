package br.com.taugs.jobinsights.api.vaga.model.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class VagaResponseDTO {

	private String cargo;
	private String nomeEmpresa;
	private BigDecimal salario;
	private String tipoVaga;

}
