package br.com.taugs.jobinsights.api.empresa.model.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class EmpresaResponseDTO {

	private String nome;
	private BigDecimal nota;
	private Integer avaliacoes;
	private Integer salarios;
	private Integer vagas;
	private String setor;
	private Integer tamanho;
	private String tamanhoStr;

}
