package br.com.taugs.jobinsights.api.salario.model.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class SalarioResponseDTO {

	private String cargo;

	private BigDecimal maior;

	private BigDecimal menor;

	private Integer total;

}
