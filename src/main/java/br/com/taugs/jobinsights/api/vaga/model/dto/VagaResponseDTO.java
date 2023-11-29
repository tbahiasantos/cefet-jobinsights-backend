package br.com.taugs.jobinsights.api.vaga.model.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import br.com.taugs.jobinsights.enums.TipoVagaEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VagaResponseDTO {

	private Long id;
	private String cargo;
	private String nomeEmpresa;
	private BigDecimal salario;
	private TipoVagaEnum tipoVaga;
	private String tipoVagaStr;
	private Timestamp dataVaga;

}
